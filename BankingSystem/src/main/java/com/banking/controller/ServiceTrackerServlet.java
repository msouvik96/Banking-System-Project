package com.banking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.bean.ServiceTracker;
import com.banking.service.BankingServiceimpl;
@WebServlet("/servicetracker")
public class ServiceTrackerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			BankingServiceimpl impl=new BankingServiceimpl();
			int accountid=Integer.parseInt(req.getParameter("Account_ID"));
			List<ServiceTracker> list=impl.serviceTracker(accountid);
			if(list!=null)
			{
				session.setAttribute("service", list);
				resp.sendRedirect("./ServiceTracker.jsp");
			}
			else
			{
				resp.sendRedirect("./Failed.jsp");
			}
		}
		else
		{
			resp.sendRedirect("./UserLogin.jsp");
		}
	}
}
