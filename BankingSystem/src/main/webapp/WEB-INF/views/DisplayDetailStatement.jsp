<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.banking.bean.FundTransfer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail Statement</title>
</head>
<body>
	<style>
.header {
	text-align: center;
	margin: 0;
	padding: 0;
	width: 1400px;
	height: 80px;
	background-size: cover;
	background-position: center;
}
</style>



	<div class="header">
		<h1>
			<h1>
				<b><center>
						<u> CODEX BANK</u>
					</center></b>
			</h1>
		</h1>
	</div>
	<br>
	<br>
	<center>
		<h2>
			<em>Detailstatement</em>
		</h2>
	</center>
	<%
		if (session == null)

		{
			response.sendRedirect("./loginpage");
		}

		else {
			List<FundTransfer> list = (List<FundTransfer>) request.getAttribute("fundtransfer");
	%>

	<style>
table, th, td {
	border: 1px solid black;
}
</style>

	<center>
		<table cellpadding="10" cellspacing="5">
			<tr>
				<th>FundTransfer_ID</th>
				<th>Account_ID</th>
				<th>Payee_Account_ID</th>
				<th>Date_Of_Transfer</th>
				<th>Transfer_Amount</th>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
						FundTransfer ft = (FundTransfer) list.get(i);
			%>
			<tr>
				<td><%=ft.getFundTransferId()%></td>
				<td><%=ft.getAccountId()%></td>
				<td><%=ft.getPayeeAccountId()%></td>
				<td><%=ft.getDateOfTransfer()%></td>
				<td><%=ft.getTransferAmount()%></td>
			</tr>
			<%
				}
			%>

		</table>

	</center>
	<%
		}
	%>

	<button>
		<a href="./successfullupage">Go Back To Home Page</a>
	</button>
</body>
</html>