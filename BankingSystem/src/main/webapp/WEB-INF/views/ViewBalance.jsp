<%@page import="com.banking.bean.AccountMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Balance</title>
</head>
<body>
<style>
body 
{
	background-image: url("./resources/Picture/trr.jpg");
	background-size: cover;
}

h1 {
	
	text-align: center;
}
</style>
	<%  AccountMaster acc=(AccountMaster)session.getAttribute("accb"); %>
	
	<h1 class="ca"><em>Your Account Balance is : <%=acc.getAccountBalance() %> </em></h1>


<button>
		<a href="./successfullupage">Go Back To Home Page</a>
	</button>
</body>
</html>