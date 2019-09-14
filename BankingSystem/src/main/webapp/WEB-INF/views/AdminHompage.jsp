<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<style>
body {
	margin: 0;
	padding: 0;
	background: url(./resources/Picture/beach.jpg);
	background-size: cover;
	font-family: sans-serif;
	color: rgb(255, 123, 0);
}

.header {
	width: 100%;
	position: fixed;
	font-size: 15px;
	background-position: center;
	background-size: cover;
	padding: 15px 0;
	color: #fff;
}

input[type="submit"] {
	border: none;
	outline: none;
	width: 300px;
	height: 190px;
	background: dodgerblue;
	color: #fff;
	font-size: 25px;
	border-radius: 20px;
}

.crateacc {
	top: 45%;
	left: 12%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 50px 30px;
}

.searchacc {
	top: 45%;
	left: 37%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 50px 30px;
}

.service {
	top: 45%;
	left: 87%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 50px 30px;
}

.deactivate {
	top: 45%;
	left: 62%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 50px 30px;
}

.logout {
	top: 80%;
	left: 37%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 50px 30px;
}

input[type="submit"]:hover {
	cursor: pointer;
	background: #5d10ec;
	color: #000;
}
</style>



	<%if (session==null)
{
	response.sendRedirect("./loginpage");
}
else
{%>
	<div class="header">
		<h1>
			<em><h1>
					<b><center>
							<u>Codex Bank</u>
						</center></b>
				</h1></em>
		</h1>
	</div>
	<div class="links">
		<form action="./createaccountpage" class="crateacc">
			<input type="submit" value="Create Account">
		</form>
		<form action="./searchaccountpage" class="searchacc">
			<input type="submit" value="Search Account">
		</form>
		<form action="./servicetrackerpage" class="service">
			<input type="submit" value="Service Tracker">
		</form>
		<form action="./deactivateaccountpage" class="deactivate">
			<input type="submit" value="Deactivate Account">
		</form>
		<form action="./logoutm" class="logout">
			<input type="submit" value="Logout Account">
		</form>
	</div>
	<%} %>
</body>
</html>