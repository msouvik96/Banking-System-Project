<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Details</title>
<!-- <link rel="stylesheet" href="./SearchAllDetails.css"> -->
</head>
<body>
	<style>
div {
	position: absolute;
	left: 500px;
	top: 200px;
	height: 100px;
	width: 200px;
	background-color: /* rgba(201, 206, 205, 0.37);  */ box-align : centre;
	right: 20px;
	padding-top: 80px;
	border-radius: 40px;
	border-spacing: 30px;
	padding-left: 50px;
	border: 20px;
	padding-bottom: 30px;
}

body {
	background-image: url("./resources/Picture/ppp.jpg");
	/* hh.jpg"); */
	background-size: cover;
}

h1 {
	font-color: white:
}

.q {
	font-size: 20px;
}

.x {
	color: white;
}

.s {
	border: none;
	outline: none;
	height: 40px;
	background: white;
	color: tranparent;
	font-size: 18px;
	border-radius: 20px;
}

input {
	border-width: 20px;
}
</style>
	<% if(session==null)
{
	response.sendRedirect("./loginpage");
}
	
else
{
	
	%>

	<br>
	<br>

	<h1>
		<h1>
			<b><center>
					<u> CODEX BANK</u>
				</center></b>
		</h1>
	</h1>

	<h1>
		<h1>
			<b><center>
					<em>Search All the Details</em>
				</center></b>
		</h1>
	</h1>
	<br>
	<br>

	<form action="./searchaccountm" method="post">

		<div>
			<label for="Account_id">Account Id:</label> <input type="number"
				name="Account_ID" id="Account_id" placeholder="Enter Account Id"
				required><br>
			<br> <input type="submit" value="Search">
		</div>
	</form>

	<%} %>
</body>
</html>