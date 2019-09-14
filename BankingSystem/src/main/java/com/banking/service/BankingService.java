package com.banking.service;

import java.sql.Date;
import java.util.List;

import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.bean.FundTransfer;
import com.banking.bean.ServiceTracker;
import com.banking.bean.Transactions;
import com.banking.bean.User;

public interface BankingService {

	boolean createAccount(AccountMaster acc, Customer cst, User user); 

	User loginAccount(int userid, String password);   

	List<FundTransfer> viewMiniStatement(int accountId );  

	List<FundTransfer> viewDetailedStatement(Date fromdate,Date todate,int accountId);  
  
	boolean changeInMobileNum(long mobileNo,int accountId);  

	boolean serviceRequest(ServiceTracker st); 
	
	List<ServiceTracker> serviceTracker(int accountId); 

	boolean fundTransfer(FundTransfer ft); 

	boolean changePassword(String loginPassword,int accountId); 

	List<Object> searchAccount(int accountId); 

	boolean deactivateAccount(int accountId);  
	
	public double checkBalance(int accountId);

}
