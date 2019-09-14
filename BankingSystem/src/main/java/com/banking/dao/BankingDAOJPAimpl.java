package com.banking.dao;


import java.sql.Date;

import java.util.LinkedList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.bean.FundTransfer;
import com.banking.bean.ServiceTracker;
import com.banking.bean.User;


@Repository
public class BankingDAOJPAimpl implements BankingDAO {

	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

	@Override
	public boolean createAccount(AccountMaster acc, Customer cst, User user) {
		boolean b=false;
		EntityManager manager=null;
		try {
			manager=emf.createEntityManager(); 
			manager.getTransaction().begin();
			manager.persist(acc);
			manager.persist(cst);
			manager.persist(user);

			b=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			b=false;
		}
		finally
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
		}
		return b;
	}

	@Override
	public User loginAccount(int userid, String password) {

		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		String query="select u from User u  Where u.userid=:userid and u.loginPassword=:password";
		Query qu=manager.createQuery(query);
		qu.setParameter("userid", userid);
		qu.setParameter("password", password);
		User user=(User) qu.getSingleResult();

		if(user!=null)
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
			return user;
		}
		else
		{
			return null;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<FundTransfer> viewMiniStatement(int accountId) {

		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		String query="select ft from FundTransfer ft where ft.accountId =:accountid";
	    Query qu=manager.createQuery(query);
		qu.setParameter("accountid", accountId);
		List<FundTransfer> list=qu.getResultList();
		if(list!=null)
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
			return list;
		}
		return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FundTransfer> viewDetailedStatement(Date fromdate, Date todate, int accountId) {
		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		String query="select ft from FundTransfer ft where ft.accountId =:accountid AND "
				+ "ft.dateofTransfer BETWEEN :fromdate AND :todate ";
		Query qu=manager.createQuery(query);
		qu.setParameter("accountid", accountId);
		qu.setParameter("fromdate", fromdate);
		qu.setParameter("todate", todate);
		List<FundTransfer> list=qu.getResultList();
		if(list!=null)
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
			return list;
		}
		return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean changeInMobileNum(long mobileNo, int accountId) {
		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		String query="update Customer set mobileno=:mobno where accountId=:accountid";
		Query qu=manager.createQuery(query);
		qu.setParameter("mobno", mobileNo);
		qu.setParameter("accountid", accountId);
		int count=qu.executeUpdate();
		if(count>0)
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
			return true;
		}
		return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean serviceRequest(ServiceTracker st) {
		boolean b=false;
		EntityManager manager=null;
		try {
			manager=emf.createEntityManager(); 
			manager.getTransaction().begin();
			manager.persist(st);
			b=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			b=false;
		}
		finally
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
		}
		return b;
	}

	@Override
	public List<ServiceTracker> serviceTracker(int accountId) {
		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		String query="select st from ServiceTracker st where st.accountId=:accountid";
		Query qu=manager.createQuery(query);
		qu.setParameter("accountid", accountId);
		List<ServiceTracker> list=qu.getResultList();
		if(list!=null)
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
			return list;
		}
		return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean fundTransfer(FundTransfer ft) {
		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		boolean b=false;
		String query1="select ac from AccountMaster ac where ac.accountId=:fraccid";
		Query qu1=manager.createQuery(query1);
		qu1.setParameter("fraccid", ft.getAccountId());
		AccountMaster fracc=(AccountMaster) qu1.getSingleResult();
		if(fracc.getAccountBalance()>ft.getTransferAmount())
		{
			double presentamount=fracc.getAccountBalance()-ft.getTransferAmount();
			String query2="update AccountMaster set accountBalance=:balance  where accountId=:fraccid ";
			Query qu2=manager.createQuery(query2);
			qu2.setParameter("balance", presentamount);
			qu2.setParameter("fraccid", ft.getAccountId());
			int count1=qu2.executeUpdate();
			if(count1>0)
			{
				String query3="select ac from AccountMaster ac where accountId=:toaccid";
				Query qu3=manager.createQuery(query3);
				qu3.setParameter("toaccid", ft.getPayeeAccountId());
				AccountMaster toacc=(AccountMaster) qu3.getSingleResult();
				if(toacc!=null)
				{
					double toamount=toacc.getAccountBalance()+ft.getTransferAmount();
					String query4="update AccountMaster set accountBalance=:toamount  where accountId=:toaccid ";
					Query qu4=manager.createQuery(query4);
					qu4.setParameter("toamount", toamount);
					qu4.setParameter("toaccid", ft.getPayeeAccountId());
					int count2=qu4.executeUpdate();
					if(count2>0)
					{
						manager.persist(ft);
						b=true;
						if(manager!=null) {
							manager.getTransaction().commit();
							manager.close();
						}
					}
				}
			}
		}
		return b;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean changePassword(String loginPassword, int accountId) {
		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		String query="update User u set u.loginPassword=:password where u.accountId=:accountid";
		Query qu=manager.createQuery(query);
		qu.setParameter("password", loginPassword);
		qu.setParameter("accountid", accountId);
		int count=qu.executeUpdate();
		if(count>0)
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
			return true;
		}
		return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Object> searchAccount(int accountId) {
		try
		{
		EntityManager manager=emf.createEntityManager();
		List<Object> list=new LinkedList<Object>();
		manager.getTransaction().begin();
		String query="select a from AccountMaster a where a.accountId=:accountid";
		String query1="select c from Customer c where c.accountId=:accountid";
		Query qu=manager.createQuery(query);
		qu.setParameter("accountid",accountId );
		Query qu1=manager.createQuery(query1);
		qu1.setParameter("accountid",accountId );
		AccountMaster acc=(AccountMaster) qu.getSingleResult();
		Customer cst=(Customer) qu1.getSingleResult();
		list.add(acc);
		list.add(cst);
		if(list!=null)
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
			return list;
		}
		return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deactivateAccount(int accountId) {
		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		String query="delete from User u where u.accountId=:accountid";
		Query qu=manager.createQuery(query);
		qu.setParameter("accountid", accountId);
		int count=qu.executeUpdate();
		if(count>0)
		{
			if(manager!=null) {
				manager.getTransaction().commit();
				manager.close();
			}
			return true;
		}
		return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public double checkBalance(int accountId) {
		try
		{
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
		String query="select acc.accountBalance from AccountMaster acc where acc.accountId =:accountid";
	    Query qu=manager.createQuery(query);
		qu.setParameter("accountid", accountId);
		double amount=(double) qu.getSingleResult();
		manager.getTransaction().commit();
		if(manager!=null) {
			manager.close();
		}
		return amount;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

}
