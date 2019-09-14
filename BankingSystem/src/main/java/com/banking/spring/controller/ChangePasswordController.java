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
public class ChangePasswordController {

	@Autowired
	BankingServiceJimpl service;
	
	
	@RequestMapping(value="/changepasswordpage",method=RequestMethod.GET)
	public ModelAndView geChangePasswordPage(ModelAndView mv)
	{
		mv.setViewName("ChangePassword");
		return mv;
	}
	@PostMapping("/changepasswordm")
	public String changePassword(@RequestParam("login_password")String password,HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			User user = (User) session.getAttribute("user");
			boolean b = service.changePassword(password, user.getAccountId());
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
