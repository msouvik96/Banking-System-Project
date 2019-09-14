package com.banking.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.bean.FundTransfer;
import com.banking.bean.ServiceTracker;
import com.banking.bean.User;
import com.banking.repository.Repository;

public class BankingDAOJDBCimpl implements BankingDAO
{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Properties prop=new Properties();

	@Override
	public boolean createAccount(AccountMaster acc, Customer cst, User user) {
		try
		{
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"), prop);
			String query1="insert into Account_Master values(?,?,?,?)";
			String query2="insert into Customer values(?,?,?,?,?,?)";
			String query3="insert into User values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query1);
			pstmt.setInt(1,acc.getAccountId());
			pstmt.setString(2, acc.getAccountType());
			pstmt.setDouble(3,acc.getAccountBalance());
			pstmt.setDate(4, acc.getOpenDate());
			int count1=pstmt.executeUpdate();
			if(count1>0)
			{
				pstmt=con.prepareStatement(query2);
				pstmt.setInt(1, cst.getAccountId());
				pstmt.setString(2, cst.getCustomer_Name());
				pstmt.setString(3, cst.getEmail());
				pstmt.setString(4,cst.getAddress());
				pstmt.setString(5, cst.getPancard());
				pstmt.setLong(6, cst.getMobileNo());
				int count2=pstmt.executeUpdate();
				if(count2>0)
				{
					pstmt=con.prepareStatement(query3);
					pstmt.setInt(1, user.getAccountId());
					pstmt.setString(2, user.getLoginPassword());
					pstmt.setString(3, user.getSecretQuestion());
					pstmt.setString(4, user.getTransactionPassword());
					pstmt.setString(5, user.getLockStatus());
					pstmt.setInt(6,user.getUserid());
					int count3=pstmt.executeUpdate();
					if(count3>0)
					{
						return true;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}

			}
			catch(Exception e)

			{
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public User loginAccount(int userid, String password) {
		User us=new User();
		try {
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			Properties prop=new Properties();
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"),prop);
			String query="select * from User where User_Id=? AND Login_Password=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, userid);
			pstmt.setString(2, password);
			rs= pstmt.executeQuery();
			if(rs.next())
			{
				us.setAccountId(rs.getInt("Account_ID"));
				us.setLockStatus(rs.getString("Lock_Status"));
				us.setUserid(rs.getInt("User_ID"));
				us.setLoginPassword(rs.getString("Login_Password"));
				us.setSecretQuestion(rs.getString("Secret_Question"));
				us.setTransactionPassword(rs.getString("Transaction_Password"));
				return us;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{if(con!=null)
			{
				con.close();
			}
			if(pstmt!=null)
			{
				pstmt.close();
			}
			if(rs!=null)
			{
				rs.close();
			}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}


	@Override
	public List<FundTransfer> viewMiniStatement(int accountid) {
		FundTransfer ft=new FundTransfer();
		List<FundTransfer> list=new ArrayList<FundTransfer>();
		try {
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			Properties prop=new Properties();
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"),prop);
			String query="select * from Fund_Transfer where Account_ID=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, accountid);
			rs=pstmt.executeQuery();
			int count = 0;
			if(count<10)
			{
				while(rs.next())
				{
					int fid=rs.getInt("FundTransfer_ID");
					int accountId=rs.getInt("Account_ID");
					int payaccountid=rs.getInt("Payee_Account_ID");
					Date date=rs.getDate("Date_Of_Transfer");
					double amount=rs.getDouble("Transfer_Amount");
					ft.setFundTransferId(fid);
					ft.setPayeeAccountId(payaccountid);
					ft.setDateOfTransfer(date);
					ft.setTransferAmount(amount);
					ft.setAccountId(accountId);
					list.add(ft);
				}
				count++;
			}
			return list;
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}

				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public List<FundTransfer> viewDetailedStatement(Date fromdate,Date todate,int accountId) {
		FundTransfer ft=new FundTransfer();
		List<FundTransfer>  list=new ArrayList<FundTransfer>();
		try
		{
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			Properties prop=new Properties();
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"),prop);
			String query="select * from Fund_Transfer where Account_ID=? AND Date_Of_Transfer BETWEEN ? AND ?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, accountId);
			pstmt.setDate(2, fromdate);
			pstmt.setDate(3, todate);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				ft.setAccountId(rs.getInt("Account_ID"));
				ft.setFundTransferId(rs.getInt("FindTransfer_ID"));
				ft.setDateOfTransfer(rs.getDate("Date-Of_Transfer"));
				ft.setPayeeAccountId(rs.getInt("Payee_Account_ID"));
				ft.setTransferAmount(rs.getDouble("Transfer_Amount"));
				list.add(ft);
				return list;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{ if(con!=null)
			{
				con.close();
			}
			if(pstmt!=null)
			{
				pstmt.close();
			}
			if(rs!=null)
			{
				rs.close();
			}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public boolean changeInMobileNum(long mobileNo,int accountId) {

		try
		{
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			Properties prop=new Properties();
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"),prop);
			String query="update Customer set Mobile_No=? where Account_ID=?";
			pstmt=con.prepareStatement(query);
			pstmt.setLong(1,mobileNo );
			pstmt.setInt(2, accountId);
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean serviceRequest(ServiceTracker st) {

		try
		{
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"), prop);
			String query="insert into Service_Tracker values(?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, st.getServiceId());
			pstmt.setString(2, st.getServiceDescription());
			pstmt.setInt(3, st.getAccountId());
			pstmt.setDate(4, st.getServiceRaisedDate());
			pstmt.setString(5, st.getServiceStatus());
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}


			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;

	}
	@Override
	public List<ServiceTracker> serviceTracker(int accountId) {
		ServiceTracker st=new ServiceTracker();
		List<ServiceTracker> list=new ArrayList<ServiceTracker>();
		try
		{

			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"), prop);
			String query="select * from Service_Tracker where Account_ID=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,accountId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				st.setAccountId(rs.getInt("Account_ID"));
				st.setServiceId(rs.getInt("Service_ID"));
				st.setServiceDescription(rs.getString("Service_Description"));
				st.setServiceRaisedDate(rs.getDate("Service_Raised_Date"));
				st.setServiceStatus(rs.getString("Service_Status"));
				list.add(st);
				return list;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{ 
				if(con!=null)
				{
					con.close();
				}

				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


		return null;
	}

	@Override
	public boolean fundTransfer(FundTransfer ft) {

		try
		{
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			Properties prop=new Properties();
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"),prop);
			String query="select * from Account_Master where Account_ID=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,ft.getAccountId());
			rs= pstmt.executeQuery();
			if(rs.next())
			{
				double availamount=rs.getDouble("Account_Balance");
				if(ft.getTransferAmount()<availamount)
				{
					String query2="update Account_Master set Account_Balance=?  where Account_ID=? ";
					double presentamount=availamount-ft.getTransferAmount();
					PreparedStatement pstmt1=con.prepareStatement(query2);
					pstmt1.setDouble(1, presentamount);
					pstmt1.setInt(2, ft.getAccountId());
					int count=pstmt1.executeUpdate();
					if(count>0)
					{
						String query5="insert into Fund_Transfer values(?,?,?,?,?)";
						PreparedStatement pstmt3=con.prepareStatement(query5);
						pstmt3.setInt(1,ft.getFundTransferId());
						pstmt3.setInt(2, ft.getAccountId());
						pstmt3.setInt(3, ft.getPayeeAccountId());
						pstmt3.setDate(4, ft.getDateOfTransfer());
						pstmt3.setDouble(5, ft.getTransferAmount());
						int count2=pstmt3.executeUpdate();
						if(count2>0)
						{
							String query1="select * from Account_Master where Account_ID=?";
							PreparedStatement pstmt5=con.prepareStatement(query1);
							pstmt5.setInt(1,ft.getPayeeAccountId());
							ResultSet rs1= pstmt5.executeQuery();
							if(rs1.next())
							{
								double topresentamount=rs1.getDouble("Account_Balance")+ft.getTransferAmount();
								String query3="update Account_Master set Account_Balance=?  where Account_ID=? ";
								PreparedStatement pstmt6=con.prepareStatement(query3);
								pstmt6.setDouble(1, topresentamount);
								pstmt6.setInt(2, ft.getPayeeAccountId());
								int count1=pstmt6.executeUpdate();
								if(count1>0)
								{
									String query6="insert into Fund_Transfer values(?,?,?,?,?)";
									PreparedStatement pstmt4=con.prepareStatement(query6);
									pstmt4.setInt(1,ft.getFundTransferId());
									pstmt4.setInt(2, ft.getPayeeAccountId());
									pstmt4.setInt(3,ft.getAccountId() );
									pstmt4.setDate(4, ft.getDateOfTransfer());
									pstmt4.setDouble(5, ft.getTransferAmount());
									int count4=pstmt.executeUpdate();
									if(count4>0)
									{
										return true;
									}
									else
									{
										return false;
									}
								}
							}
							else
							{
								return false;
							}
						}
					}
					else
					{
						return false;
					}
				}
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean changePassword(String loginPassword,int accountId) {
		try
		{
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			Properties prop=new Properties();
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"),prop);
			String query="update User set Login_Password=? where Account_ID=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,loginPassword);
			pstmt.setInt(2, accountId);
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}


			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<Object> searchAccount(int accountId) {
		AccountMaster acc=new AccountMaster();
		Customer cst=new Customer();
		try
		{
			List<Object> list=new ArrayList();
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			Properties prop=new Properties();
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"),prop);
			String query="select * from Account_Master where Account_ID=?";
			String query1="select * from Customer where Account_ID=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, accountId);
			rs= pstmt.executeQuery();
			if(rs.next())
			{
				acc.setAccountId(rs.getInt("Account_ID"));
				acc.setAccountType(rs.getString("Account_Type"));
				acc.setAccountBalance(rs.getDouble("Account_Balance"));
				acc.setOpenDate(rs.getDate("Open_Date"));

				pstmt=con.prepareStatement(query1);
				pstmt.setInt(1, accountId);
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					cst.setAccountId(rs.getInt("Account_ID"));
					cst.setCustomerName(rs.getString("Customer_Name"));
					cst.setAddress(rs.getString("Address"));
					cst.setEmail(rs.getString("Email"));
					cst.setMobileNo(rs.getLong("Mobile_No"));
					cst.setPancard(rs.getString("Pancard"));

					list.add(acc);
					list.add(cst);
				}
				return list;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{ if(con!=null)
			{
				con.close();
			}
			if(pstmt!=null)
			{
				pstmt.close();
			}


			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}

		return null;
	}

	@Override
	public boolean deactivateAccount(int accountId) {
		try {
			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			Properties prop=new Properties();
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"),prop);
			String query="delete from User where Account_ID=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, accountId);
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}


			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public double checkBalance(int accountId) {
		try
		{

			Class.forName(Repository.getRepo().get("driver"));
			FileReader file=new FileReader(Repository.getRepo().get("prop"));
			prop.load(file);
			con=DriverManager.getConnection(Repository.getRepo().get("url"), prop);
			String query="select * from Account_Master where Account_ID=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,accountId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				double amount=rs.getDouble("Account_Balance");
				return amount;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			try
			{ 
				if(con!=null)
				{
					con.close();
				}

				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}


}
