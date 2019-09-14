package com.banking.spring.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.bean.FundTransfer;
import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller
public class FundTransferController {

	@Autowired
	BankingServiceJimpl service;
	@RequestMapping(value="/fundtransferpage",method=RequestMethod.GET)
	public ModelAndView getFundTransferPage(ModelAndView mv)
	{
		mv.setViewName("FundTransfer");
		return mv;
	}
	@PostMapping("/fundtransferm")
	public String fundTransfer(@RequestParam("toaccount_id")int toaccid,
			@RequestParam("date")Date date,@RequestParam("amount")double amount,HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			User user=(User) session.getAttribute("user");
			FundTransfer ft=new FundTransfer();
			ft.setAccountId(user.getAccountId());
			ft.setPayeeAccountId(toaccid);
			ft.setDateOfTransfer(date);
			ft.setTransferAmount(amount);
			boolean b=service.fundTransfer(ft);
			if(b)
			{
				return "Successfullu";
			}
			else
			{
				return "Failed";
			}
		}
		else
		return "UserLogin";
		
	}
	
	

}
