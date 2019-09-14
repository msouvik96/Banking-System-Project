package com.banking.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.bean.FundTransfer;
import com.banking.bean.ServiceTracker;
import com.banking.bean.User;
import com.banking.dao.BankingDAO;
import com.banking.dao.BankingDAOJPAimpl;

@Service
public class BankingServiceJimpl implements BankingService {

	@Autowired
	BankingDAOJPAimpl dao;
	BankingDAO impl=new BankingDAOJPAimpl();
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
		User user=impl.loginAccount(userid, password);
		if(user!=null)
		{
			return user;
		}
		return null;
	}

	@Override
	public List<FundTransfer> viewMiniStatement(int accountId) {
		List<FundTransfer> list=impl.viewMiniStatement(accountId);
		if(list!=null)
		{
			return list;
		}
		return null;
	}

	@Override
	public List<FundTransfer> viewDetailedStatement(Date fromdate, Date todate, int accountId) {
		List<FundTransfer> list=impl.viewDetailedStatement(fromdate,todate,accountId);
		if(list!=null)
		{
			return list;
		}

		return null;
	}
	
	@Override
	public boolean changeInMobileNum(long mobileNo, int accountId) {
		boolean b=impl.changeInMobileNum(mobileNo, accountId);
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
	public List<ServiceTracker> serviceTracker(int accountId) {
		List<ServiceTracker> list=impl.serviceTracker(accountId);
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
	public boolean changePassword(String loginPassword, int accountId) {
		boolean b=impl.changePassword(loginPassword, accountId);
		if(b==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Object> searchAccount(int accountId) {
		List<Object> list=impl.searchAccount(accountId);
		if(list!=null)
		{
			return list;
		}
		return null;
	}

	@Override
	public boolean deactivateAccount(int accountId) {
		boolean b=impl.deactivateAccount(accountId);
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
