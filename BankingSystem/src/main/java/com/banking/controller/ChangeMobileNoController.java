
package com.banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceimpl;
@WebServlet("/changemobno")
public class ChangeMobileNoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			BankingService impl=new BankingServiceimpl();
			User us=(User) session.getAttribute("user");
			long mobileno=Long.parseLong(req.getParameter("mobile_No"));
			boolean b=impl.changeInMobileNum(mobileno,us.getAccountId());
			if(b==true)
			{
				resp.sendRedirect("./Successfull.jsp");
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