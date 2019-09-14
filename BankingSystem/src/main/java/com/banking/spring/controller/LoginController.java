package com.banking.spring.controller;

import java.util.List;

import javax.servlet.http.Cookie;
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

public class LoginController {

	@Autowired
	BankingServiceJimpl service;
	
	@RequestMapping(value="/loginpage",method=RequestMethod.GET)
	public String getLoginPage()
	{
		return "UserLogin";
	}
	@RequestMapping(value="/loginm",method=RequestMethod.POST)
	public ModelAndView doLogin(
			@RequestParam("userid")int userid,@RequestParam("password")String password,HttpServletRequest req,
			HttpServletResponse resp,ModelAndView mv,Model model
			)
	{
		{
			User user=service.loginAccount(userid, password);
			if(user!=null)
			{
				HttpSession session = req.getSession();	
				if(userid==100)
				{
					Cookie cookie=new Cookie("password", user.getLoginPassword());
					resp.addCookie(cookie);
					session.setAttribute("user", user);
					mv.setViewName("AdminHompage");
					return mv;
				}
				else
				{
					Cookie cookie=new Cookie("password", user.getLoginPassword());
					resp.addCookie(cookie);
					session.setAttribute("user", user);
					mv.setViewName("UserHomepage");
					return mv;
				}
				
			}
			else
			{
				mv.setViewName("UserLogin");
				return mv;
			}
		}
	}
}
