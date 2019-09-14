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

import com.banking.bean.ServiceTracker;
import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller

public class ServiceRequestController {

	@Autowired
	BankingServiceJimpl service;
	@RequestMapping(value="/servicerequestpage",method=RequestMethod.GET)
	public ModelAndView getServiceRequestPage(ModelAndView mv)
	{
		mv.setViewName("ServiceRequest");
		return mv;
	}
	@PostMapping("/servicerequestm")
	public String serviceRequest(
			@RequestParam("Service_Description")String servicedescrip,
			@RequestParam("Service_Raised_Date")Date date,@RequestParam("service_status")String status,
			HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			ServiceTracker st=new ServiceTracker();
			User user=(User) session.getAttribute("user");
			st.setAccountId(user.getAccountId());
			st.setServiceDescription(servicedescrip);
			st.setServiceRaisedDate(date);
			st.setServiceStatus(status);
			boolean b = service.serviceRequest(st);
			if(b)
			{
				return "Successfullu";
			}
			else
			{
				return "Failed";
			}
		}
		return "UserLogin";
	}
}
