<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>

</head>
<body>
	<style>
div
 {
	position: absolute;
	left: 500px;
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
	font-size:20px;
}

body 
{
	background-image: url("./resources/Picture/trr.jpg");
	background-size: cover;
}

h2 {
	
	text-align: center;
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
.s
{
   border-width:10px;
}

h3 {
	top: 800px;
	font-size: 35px;
	color: darkcyan;
}
</style>


	<%if (session==null)
{
	response.sendRedirect("./loginpage");
}
else
{%>
<br>



	
		<h2>
			<h2>
				<b><center>
						<u> CODEX BANK</u>
					</center></b>
			</h2>
		</h2>
	
	<h1>
		<h1>
			<b><center>
					Request For Change Password
				</center></b>
		</h1>
	</h1>
	<br>
	<br>




	<form action="./changepasswordm" method="post">
		<div>
			<center>
				<label for="loginpassword">Login Password: </label> <input
					type="text" name="login_password" id="loginpassword" placeholder="Enter Password" required><br>
				<br>
				<br>
				<input type="submit" value="UPDATE">
				&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp<input type="reset"
					value="RESET"><br>
		</div>
		</center>

	</form>
	<%} %>
</body>
</html>