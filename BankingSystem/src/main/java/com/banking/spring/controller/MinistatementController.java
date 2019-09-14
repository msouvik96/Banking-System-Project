package com.banking.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.banking.bean.FundTransfer;
import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller

public class MinistatementController {

	@Autowired
	BankingServiceJimpl service;
	@GetMapping("/ministatementm")
	public String miniStatement(Model model,HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			User user=(User) session.getAttribute("user");
			List<FundTransfer> ft = service.viewMiniStatement(user.getAccountId());
			if(ft!=null)
			{
				model.addAttribute("ft", ft);
				return "Ministatement";
			}
			else
			{
				return "Failed";
			}
		}
		return "UserLogin";
	}
}
