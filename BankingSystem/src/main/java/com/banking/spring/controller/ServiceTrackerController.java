package com.banking.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.bean.ServiceTracker;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller

public class ServiceTrackerController {
	@Autowired
	BankingServiceJimpl service;
	@RequestMapping(value="/servicetrackerpage",method=RequestMethod.GET)
	public  ModelAndView getServiceTrackerPage(ModelAndView mv)
	{
		mv.setViewName("RequestServiceTracker");
		return mv;
	}
	@PostMapping("/servicetrackerm")
	public String serviceTracker(@RequestParam("Account_ID")int accid,HttpServletRequest req,Model model)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			List<ServiceTracker> list = service.serviceTracker(accid);
			if(list!=null)
			{
				model.addAttribute("servicetracker", list);
				return "ServiceTracker";
			}
			else
			{
				return "RequestServiceTracker";
			}
		}
		return "UserLogin";
		
	}
	
	
}
