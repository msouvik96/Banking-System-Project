package com.banking.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.bean.FundTransfer;
import com.banking.bean.User;
import com.banking.service.BankingServiceimpl;
@WebServlet("/fundtransfer")
public class FundTransferServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			try {
				
			BankingServiceimpl impl=new BankingServiceimpl();
			User user=(User) session.getAttribute("user");
			int fundtransferid=Integer.parseInt(req.getParameter("fundtransfer-id"));
			int toaccountid=Integer.parseInt(req.getParameter("toaccount_id"));
			SimpleDateFormat date= new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date open=date.parse(req.getParameter("date"));
			java.sql.Date dateoftransfer=new java.sql.Date(open.getTime());
			double amount=Double.parseDouble(req.getParameter("amount"));
			FundTransfer ft=new FundTransfer();
			ft.setAccountId(user.getAccountId());
			ft.setFundTransferId(fundtransferid);
			ft.setPayeeAccountId(toaccountid);
			ft.setDateOfTransfer(dateoftransfer);
			ft.setTransferAmount(amount);
			boolean b=impl.fundTransfer(ft);
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
