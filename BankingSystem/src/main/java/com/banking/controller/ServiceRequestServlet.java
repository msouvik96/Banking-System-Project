package com.banking.controller;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.bean.ServiceTracker;
import com.banking.bean.User;
import com.banking.service.BankingServiceimpl;
@WebServlet("/servicerequest")
public class ServiceRequestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			try
			{
			BankingServiceimpl impl=new BankingServiceimpl();
			User user=(User) session.getAttribute("user");
			int serviceid=Integer.parseInt(req.getParameter("Service_ID"));
			String servicedescription=req.getParameter("Service_Description");
			Date date1=(Date) new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("Service_Raised_Date"));
			java.sql.Date date=new java.sql.Date(date1.getTime()); 
			String status=req.getParameter("service_status");
			ServiceTracker st=new ServiceTracker();
			st.setAccountId(user.getAccountId());
			st.setServiceId(serviceid);
			st.setServiceDescription(servicedescription);
			st.setServiceRaisedDate(date);
			st.setServiceStatus(status);
			boolean b=impl.serviceRequest(st);
			if(b==true)
			{
				resp.sendRedirect("./Successfull.jsp");
			}
			else
			{
				resp.sendRedirect("./Failed.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		else
		{
			resp.sendRedirect("./UserLogin.jsp");
		}
		
	}
}
