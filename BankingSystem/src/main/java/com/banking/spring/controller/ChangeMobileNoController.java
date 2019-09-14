package com.banking.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller
public class ChangeMobileNoController {
	@Autowired
	BankingServiceJimpl service;
	
	@RequestMapping(value="/changemobilepage",method=RequestMethod.GET)
	public ModelAndView getChangeMobilePage(ModelAndView mv)
	{
		mv.setViewName("ChangeMobile");
		return mv;
	}
	@PostMapping("/changemobnom")
	public ModelAndView changeMobileNo(@RequestParam("mobile_No")long mobileNo,HttpServletRequest req,ModelAndView mv)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			User user=(User) session.getAttribute("user");
			boolean b=service.changeInMobileNum(mobileNo,user.getAccountId());
			if(b)
			{
				mv.setViewName("Successfullu");
			}
			else
			{
				mv.setViewName("ChangeMobile");
			}
		}
		
		return mv;
	}
	
}
