<%@page import="com.banking.bean.ServiceTracker"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requested Service List</title>
</head>
<body>
	<style>
body {
	background-image: url(" ./resources/Picture/service.jpg");
	background-size: cover;
	border-width: 10px;
}
</style>

	<div class="header">
		<h1>
			<h1>
				<b><center>
						<u>CODEX BANK</u>
					</center></b>
			</h1>
		</h1>
	</div>
	<br>
	<br>


	<center>
		<h2>
			<em>Service Tracker</em>
		</h2>
	</center>




	<%
				if (session == null) {
					response.sendRedirect("./loginpage");
				}

				else {
					List<ServiceTracker> list = (List<ServiceTracker>) request.getAttribute("servicetracker");
				
			%>
	<style>
table, th, td {
	border: 1px solid black;
}
</style>
	<center>
		<table cellpadding="10" cellspacing="5">
			<tr>

				<th>Account ID</th>
				<th>Service ID</th>
				<th>Service Description</th>
				<th>Service Raised Date</th>
				<th>Service Status</th>
			</tr>


			<%	for (int i = 0; i < list.size(); i++) {

				ServiceTracker st = (ServiceTracker) list.get(i); %>
			<tr>
				<td><%=st.getAccountId()%></td>
				<td><%=st.getServiceId()%></td>
				<td><%=st.getServiceDescription()%></td>
				<td><%=st.getServiceRaisedDate()%></td>
				<td><%=st.getServiceStatus()%></td>
			</tr>
			<%} %>

		</table>
		<%
			}

		%>

		<button>
			<a href="./successfullpage">Go Back To Home Page</a>
		</button>
</body>
</html>