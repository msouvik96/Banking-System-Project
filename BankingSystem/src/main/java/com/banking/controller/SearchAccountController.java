package com.banking.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.service.BankingServiceimpl;
@WebServlet("/searchaccount")
public class SearchAccountController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			resp.setContentType("text/html");
			BankingServiceimpl impl=new BankingServiceimpl();
			int accountid=Integer.parseInt(req.getParameter("Account_ID"));
			List<Object> list=impl.searchAccount(accountid);
			if(list!=null)
			{
				Iterator itr=list.iterator();
				if(itr.hasNext())
				{
					AccountMaster acc=(AccountMaster) itr.next();
					Customer cst=(Customer) itr.next();
					session.setAttribute("acc", acc);
					session.setAttribute("cst", cst);
					resp.sendRedirect("./DisplayAllDetails.jsp");
				}
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
