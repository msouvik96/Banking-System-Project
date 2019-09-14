package com.banking.spring.controller;

import java.util.Iterator;
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

import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceJimpl;

@Controller
public class SearchAccountController {
	@Autowired
	BankingServiceJimpl service;
	@RequestMapping(value="/searchaccountpage",method=RequestMethod.GET)
	public ModelAndView getServiceRequestPage(ModelAndView mv)
	{
		mv.setViewName("SearchAllDetails");
		return mv;
	}
	@PostMapping("/searchaccountm")
	public String searchAccount(@RequestParam("Account_ID")int accid,HttpServletRequest req,Model model)
	{
		HttpSession session=req.getSession(false);
		if(session!=null) {
			List<Object> list = service.searchAccount(accid);
			if(list!=null)
			{
				Iterator itr=list.iterator();
				if(itr.hasNext())
				{
					AccountMaster acc=(AccountMaster) itr.next();
					Customer cst=(Customer) itr.next();
					model.addAttribute("acc", acc);
					model.addAttribute("cst", cst);
					req.setAttribute("name", "Souvik");
					return"DisplayAllDetails";
				}
			}
			else

				return "Failed";
		}
		return "UserLogin";
	}
}
