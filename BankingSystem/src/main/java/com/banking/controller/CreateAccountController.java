package com.banking.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.bean.AccountMaster;
import com.banking.bean.Customer;
import com.banking.bean.User;
import com.banking.service.BankingService;
import com.banking.service.BankingServiceimpl;
@WebServlet("/addaccount")
public class CreateAccountController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			try {
				
			
			AccountMaster acc=new AccountMaster();
			Customer cst=new Customer();
			User user=new User();
			BankingService impl=new BankingServiceimpl();
			int accountid=Integer.parseInt(req.getParameter("accnumber"));
			String accounttype=req.getParameter("acctype");
			double accountbalance=Double.parseDouble(req.getParameter("accbalance"));
			SimpleDateFormat date= new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date open=date.parse(req.getParameter("day"));
			java.sql.Date opendate=new java.sql.Date(open.getTime());
		
			String customername=req.getParameter("Customername");
			String email=req.getParameter("mail");
			long mobileno=Long.parseLong(req.getParameter("MobileNo"));
			String address=req.getParameter("address");
			String pancard=req.getParameter("pancard");
			int userid=Integer.parseInt(req.getParameter("userid"));
			String loginpassword=req.getParameter("password");
			String secretquestion=req.getParameter("question");
			String transactionpassword=req.getParameter("Pass");
			String lockStatus=req.getParameter("lockstatus");

			acc.setAccountId(accountid);
			acc.setAccountBalance(accountbalance);
			acc.setAccountType(accounttype);
			acc.setOpenDate(opendate);

			cst.setAccountId(accountid);
			cst.setCustomerName(customername);
			cst.setAddress(address);
			cst.setEmail(email);
			cst.setPancard(pancard);
			cst.setMobileNo(mobileno);

			user.setAccountId(accountid);
			user.setUserid(userid);
			user.setSecretQuestion(secretquestion);
			user.setLoginPassword(loginpassword);
			user.setTransactionPassword(transactionpassword);
			user.setLockStatus(lockStatus);

			boolean b=impl.createAccount(acc, cst, user);
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
