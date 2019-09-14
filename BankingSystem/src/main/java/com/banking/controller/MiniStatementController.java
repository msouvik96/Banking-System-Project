package com.banking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.bean.FundTransfer;
import com.banking.bean.User;
import com.banking.service.BankingServiceimpl;
@WebServlet("/ministatement")
public class MiniStatementController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			BankingServiceimpl impl=new BankingServiceimpl();
			User us = (User)session.getAttribute("user");
			List<FundTransfer> list=impl.viewMiniStatement(999999);
			if(list!=null)
			{
				session.setAttribute("ministatement", list);
				resp.sendRedirect("./Ministatement.jsp");
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
