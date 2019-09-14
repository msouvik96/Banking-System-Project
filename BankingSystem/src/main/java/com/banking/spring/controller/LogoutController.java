package com.banking.spring.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller

public class LogoutController {

	@Autowired
	BankingServiceJimpl service;
	@GetMapping("/logoutm")
	public String getLogout(HttpServletRequest req,HttpServletResponse resp)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			Cookie []cookie = req.getCookies();
			if(cookie!=null)
			{
				for(Cookie cookie1:cookie)
				{
					String name = cookie1.getName();
					if(name.equalsIgnoreCase("password"))
					{
						cookie1.setMaxAge(0);
						resp.addCookie(cookie1);
						session.invalidate();
					}
					return "UserLogin";
				}
			}
		}
		return "UserLogin";
	}
}
