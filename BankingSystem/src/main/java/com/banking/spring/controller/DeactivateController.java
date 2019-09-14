package com.banking.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller

public class DeactivateController {

	@Autowired
	BankingServiceJimpl service;
	
	@RequestMapping(value="/deactivateaccountpage",method=RequestMethod.GET)
	public ModelAndView getDeactivatePage(ModelAndView mv)
	{
		mv.setViewName("DeactivateAccount");
		return mv;
	}
	@RequestMapping(value="/deactivateaccountm",method=RequestMethod.POST)
	public String deactivateAccount(@RequestParam("Account_ID")int accountid,HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			boolean b = service.deactivateAccount(accountid);
			if(b)
			{
				return "Successfull";
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
