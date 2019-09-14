<%@page import="com.banking.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.banking.bean.AccountMaster"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details Of Customer</title>
</head>
<body>
	<style>
body {
	margin: 0;
	padding: 0;
	background-image: url("./resources/Picture/sky.jpg");
	margin: 0;
	padding: 0;
	background-size: cover;
	background-position: center;
	font-family: sans-serif;
	color: black;
}

.header {
	width: 1400px;
	height: 80px;
	background: #5d10ec;
	background: url(./resources/Picture/BankHeader.jpg);
	background-size: cover;
	background-position: center;
	margin-top: 0px;
}
</style>


	<%
	if (session==null)
{
	response.sendRedirect("./loginpage");
}
else
{
	   AccountMaster acc=( AccountMaster)request.getAttribute("acc");
	   Customer cst=(Customer)request.getAttribute("cst");
%>
	<div class="header">
		<h1>
			<h1>
				<b><center>
						<u>WELCOME TO CODEX BANK</u>
					</center></b>
			</h1>
		</h1>
	</div>
	<br>
	<br>
	<center>
		<h1>
			<em>Account Details</em>
		</h1>
	</center>
	<br>
	<br>
	<br>
	<br>
	<style>
table, th, td {
	border: 1px solid black;
}
</style>

	<center>
		<table cellpadding="10" cellspacing="5">
			<tr>
				<th>Account ID</th>
				<th>Account Type</th>
				<th>Account Balance</th>
				<th>Open Date</th>
			</tr>
			<tr>
				<td><%=acc.getAccountId()%></td>
				<td><%=acc.getAccountType() %></td>
				<td><%=acc.getAccountBalance()%></td>
				<td><%= acc.getOpenDate()%></td>
			</tr>


		</table>
	</center>
	<br>
	<br>
	<center>
		<h1>
			<em>Personal Details</em>
		</h1>
	</center>
	<br>
	<br>
	<center>
		<table cellpadding="10" cellspacing="5">
			<tr>
				<th>Customer Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>PanCard</th>
				<th>Mobile No</th>
			</tr>
			<tr>
				<td><%=cst.getCustomer_Name()%></td>
				<td><%=cst.getEmail()%></td>
				<td><%=cst.getAddress() %></td>
				<td><%= cst.getPancard()%></td>
				<td><%=cst.getMobileNo()%></td>
			</tr>


		</table>
	</center>


	<button>
		<a href="./successfullpage">Go Back To Home Page</a>
	</button>
	<%} %>
</body>
</html>