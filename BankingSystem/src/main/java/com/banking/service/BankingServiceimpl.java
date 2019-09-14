package com.banking.service;

import java.sql.Date;
import java.util.List;

import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.bean.FundTransfer;
import com.banking.bean.ServiceTracker;
import com.banking.bean.Transactions;
import com.banking.bean.User;
import com.banking.dao.BankingDAO;
import com.banking.dao.BankingDAOJDBCimpl;

public class BankingServiceimpl implements BankingService
{
	BankingDAO impl=new BankingDAOJDBCimpl();
	@Override
	public boolean createAccount(AccountMaster acc, Customer cst, User user) {

		boolean b=impl.createAccount(acc, cst, user);
		if(b==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public User loginAccount(int userid, String password) {

		User us=impl.loginAccount(userid, password);
		if(us!=null)
		{
			return us;
		}
		return null;
	}

	@Override
	public List<FundTransfer> viewMiniStatement(int accountid) {
		List<FundTransfer> list=impl.viewMiniStatement(accountid);
		if(list!=null)
		{
			return list;
		}

		return null;
	}

	@Override
	public List<FundTransfer> viewDetailedStatement(Date fromdate,Date todate,int accountid) {

		List<FundTransfer> list=impl.viewDetailedStatement(fromdate,todate,accountid);
		if(list!=null)
		{
			return list;
		}

		return null;
	}

	@Override
	public boolean changeInMobileNum(long mobileno,int accountid) {
		boolean b=impl.changeInMobileNum(mobileno, accountid);
		if(b==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean serviceRequest(ServiceTracker st) {

		boolean b=impl.serviceRequest(st);
		if(b==true)
		{
			return true;
		}

		return false;
	}

	@Override
	public List<ServiceTracker> serviceTracker(int accountid) {
		List<ServiceTracker> list=impl.serviceTracker(accountid);
		if(list!=null)
		{
			return list;
		}
		return null;
	}

	@Override
	public boolean fundTransfer(FundTransfer ft) {
		boolean b=impl.fundTransfer(ft);
		if(b==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean changePassword(String loginpassword,int accountid) {
		boolean b=impl.changePassword(loginpassword, accountid);
		if(b==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Object> searchAccount(int accountid) {
		List<Object> list=impl.searchAccount(accountid);
		if(list!=null)
		{
			return list;
		}
		return null;
	}

	@Override
	public boolean deactivateAccount(int accountid) {

		boolean b=impl.deactivateAccount(accountid);
		if(b==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public double checkBalance(int accountId) {
		double d=impl.checkBalance(accountId);
		if(d>=0)
		{
			return d;
		}
		return 0;
	}

}
