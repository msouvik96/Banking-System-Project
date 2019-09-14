package com.banking.spring.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.bean.FundTransfer;
import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller

public class DetailStatementController {

	@Autowired
	BankingServiceJimpl service;
	@RequestMapping(value="/detailstatementpage",method=RequestMethod.GET)
	public ModelAndView getDetailStatementPage(ModelAndView mv)
	{
		mv.setViewName("DetailStatement");
		return mv;
	}
	@GetMapping("/detailstatementm")
	public String detailStatement(@RequestParam("fromdate")Date fromdate,
			@RequestParam("todate")Date todate,Model model,HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			User user=(User) session.getAttribute("user");
			List<FundTransfer> ft = service.viewDetailedStatement(fromdate, todate, user.getAccountId());
			if(ft!=null)
			{
				model.addAttribute("fundtransfer", ft);
				return "DisplayDetailStatement";
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
