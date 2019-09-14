<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Track Pending Service</title>
<link rel="stylesheet" href="./SearchAllDetails.css">
</head>
<body>
	<style>
div {
	position: absolute;
	left: 650px;
	top: 200px;
	height: 150px;
	width: 200px;
	background-color: lightgreen;
	box-align: centre;
	right: 20px;
	padding-top: 80px;
	border-radius: 40px;
	border-spacing: 30px;
	padding-left: 50px;
	border: 20px;
	padding-bottom: 30px;
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

body {
	background-image: url("./resources/Picture/lll.jpg");
	background-size: cover;
}

.section {
	font-size: 20px;
	direction: ltr;
	text-align: right;
	text-decoration-color: azure;
	text-emphasis-color: white;
}

p {
	direction: ltr;
	top: 900;
	padding-left: 200px;
	font: bold;
	font-size: 45px;
	left: 100px;
	right: 300px;
}

h3 {
	top: 800px;
	font-size: 35px;
	color: darkcyan;
}
/* .header
{
font-size:15px;} */
</style>


	<% if(session==null)
{
	response.sendRedirect("./loginpage");
}
	
else
{
	
	%>

	<div class="header">
		<h1>
			<h1>
				<b><center>
						<u> CODEX BANK</u>
					</center></b>
			</h1>
		</h1>
	</div>
	<h1>
		<h1>
			<b><center>
					<em>Track the Service</em>
				</center></b>
		</h1>
	</h1>
	<br>
	<br>
	<form action="./servicetrackerm" method="post">

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