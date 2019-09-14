package com.banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.service.BankingService;
import com.banking.service.BankingServiceimpl;
@WebServlet("/deactivate")
public class DeactivateAccountServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			BankingService impl=new BankingServiceimpl();
			int accountid=Integer.parseInt(req.getParameter("Account_ID"));
			boolean b=impl.deactivateAccount(accountid);
			if(b==true)
			{
				resp.sendRedirect("./Successfull.jsp");
			}
			else
			{
				resp.sendRedirect("./DeactivateAccount.jsp");
			}
		}
		else
		{
			resp.sendRedirect("./UserLogin.jsp");
		}
	}
}
