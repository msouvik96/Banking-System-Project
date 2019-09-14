package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.bean.User;
import com.banking.service.BankingServiceimpl;
@WebServlet("/userlogin")
public class UserLoginController  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int count = 1;
		 if(count<=3)
		 {
		
		BankingServiceimpl impl=new BankingServiceimpl();
		int userid=Integer.parseInt(req.getParameter("userid"));
		String password=req.getParameter("password");
		User us=impl.loginAccount(userid, password);
		if(us!=null)
		{
			HttpSession session = req.getSession();
			session.setAttribute("user", us);
			if(userid==100)
			{
			   resp.sendRedirect("./AdminHompage.jsp");
			}
			else
			{
				resp.sendRedirect("./UserHomepage.jsp");
			}
		}
		else
		{
			count++;
			resp.sendRedirect("./UserLogin.jsp");
		}
		
		
	}
		 else
		 {
			 PrintWriter out=resp.getWriter();
			 out.print("please try after 30 sec");
			 Runnable r=()->
			 {
				 try {
					Thread.sleep(3000*10);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 };
			 count=0;
			 Thread th=new Thread(r);
			 th.start();
		 }
	}
}