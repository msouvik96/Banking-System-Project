package com.banking.spring.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;
@Controller

public class CreateAccountController {

	@Autowired
	BankingServiceJimpl service;

	@RequestMapping(value="/createaccountpage",method=RequestMethod.GET)
	public ModelAndView getCreateAccountPage(ModelAndView mv)
	{
		mv.setViewName("CreateAccount");
		return mv;
	}
	@RequestMapping(value="/createaccountm",method=RequestMethod.POST)
	public String createAccount(HttpServletRequest req,
			@RequestParam("accnumber")int accountno,@RequestParam("acctype")String accountype,
			@RequestParam("accbalance")double accountBalance,@RequestParam("day")Date date,
			@RequestParam("Customername")String customerName,@RequestParam("mail")String email,
			@RequestParam("MobileNo")long mobileNo,@RequestParam("address")String address,
			@RequestParam("pancard")String pancard,@RequestParam("userid")int userId,
			@RequestParam("password")String loginPassword,@RequestParam("question")String question,
			@RequestParam("Pass")String transactionPassword,@RequestParam("lockstatus")String lockStatus)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			try {


				AccountMaster acc=new AccountMaster();
				Customer cst=new Customer();
				User user=new User();			
				acc.setAccountId(accountno);
				acc.setAccountBalance(accountBalance);
				acc.setAccountType(accountype);
				acc.setOpenDate(date);

				cst.setAccountId(accountno);
				cst.setCustomerName(customerName);
				cst.setAddress(address);
				cst.setEmail(email);
				cst.setPancard(pancard);
				cst.setMobileNo(mobileNo);

				user.setAccountId(accountno);
				user.setUserid(userId);
				user.setSecretQuestion(question);
				user.setLoginPassword(loginPassword);
				user.setTransactionPassword(transactionPassword);
				user.setLockStatus(lockStatus);

				boolean b=service.createAccount(acc, cst, user);
				if(b==true)
				{
					return "Successfull";
				}
				else
				{
					return  "Failed";
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			return "UserLogin";
		}
		return null;
	}










}
