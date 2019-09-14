package com.banking.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.banking.bean.AccountMaster;
import com.banking.bean.User;
import com.banking.service.BankingServiceJimpl;

@Controller
public class CheckBalanceController {

	@Autowired
	BankingServiceJimpl service;
	@GetMapping("checkbalance")
	public String checkBalance(
			HttpServletRequest req
			)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			User user=(User) session.getAttribute("user");
			double checkBalance = service.checkBalance(user.getAccountId());
			AccountMaster acc=new AccountMaster();
			acc.setAccountBalance(checkBalance);
			if(acc!=null)
			{
				session.setAttribute("accb", acc);
				return "ViewBalance";
			}
			else
			{
				return "UserHomepage";
			}
			
		}
		return "UserLogin";
		
	}
	
}
