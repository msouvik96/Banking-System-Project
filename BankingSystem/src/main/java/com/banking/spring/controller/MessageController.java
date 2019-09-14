package com.banking.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

	
	@RequestMapping(value="/successfullpage",method=RequestMethod.GET)
	public ModelAndView getSuccessfullPage(ModelAndView mv)
	{
		mv.setViewName("AdminHompage");
		return mv;
	}
	
	@RequestMapping(value="/successfullupage",method=RequestMethod.GET)
	public ModelAndView getSuccessfulluPage(ModelAndView mv)
	{
		mv.setViewName("UserHomepage");
		return mv;
	}
}
