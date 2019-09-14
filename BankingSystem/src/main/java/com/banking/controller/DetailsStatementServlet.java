package com.banking.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet("/detailstatement")
public class DetailsStatementServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			BankingServiceimpl impl=new  BankingServiceimpl();
			User user=(User) session.getAttribute("user");
			SimpleDateFormat date= new SimpleDateFormat("yyyy-mm-dd");
			try {
				java.util.Date open = date.parse(req.getParameter("fromdate"));
				java.sql.Date fromdate=new java.sql.Date(open.getTime());
				SimpleDateFormat tdate= new SimpleDateFormat("yyyy-mm-dd");
				java.util.Date topen=tdate.parse(req.getParameter("todate"));
				java.sql.Date todate=new java.sql.Date(topen.getTime());
			
			
			List<FundTransfer> list=impl.viewDetailedStatement(fromdate,todate,user.getAccountId());
			if(list!=null)
			{
				session.setAttribute("detailstatement", list);
				resp.sendRedirect("./DisplayDetailstatement.jsp");
			}
			else
			{
				resp.sendRedirect("./Failed.jsp");
			}
		}
		 catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			resp.sendRedirect("./UserLogin.jsp");
		}
	}
}
