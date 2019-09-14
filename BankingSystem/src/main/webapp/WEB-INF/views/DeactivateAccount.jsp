<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deactivate Account</title>
</head>

<body>
	<style>
div {
	position: absolute;
	left: 900px;
	top: 200px;
	height: 150px;
	width: 200px;
	background-color: khaki;
	box-align: centre;
	right: 20px;
	padding-top: 80px;
	border-radius: 40px;
	border-spacing: 30px;
	padding-left: 50px;
	border: 20px;
	padding-bottom: 30px;
	font-size: 20px;
}

h1 {
	right: 20px;
	color:khaki ;
}

body {
	background-image: url("./resources/Picture/bank-vault-1_full.jpg");
	background-size: cover;
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

button {
	text-emphasis: centre;
	background: lightgreen;
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
			<h1>
				<b><center>
						<u> CODEX BANK</u>
					</center></b>
			</h1>
		</h1>
	</div>
	<br>
	<br>
	<h1>
		<h1>
			<b><center>
					Deactivate Account
				</center></b>
		</h1>
	</h1>
	<br>
	<br>


	<form action=" ./deactivateaccountm" method="post">

		<div>
			<label for="Acc Id"> Account Id:</label> <input type="number"
				name="Account_ID" id="Acc Id" 
				placeholder="Enter Account Id" required> <br> <br>
			<centre> <input type="submit" value="Close Account">
			</centre>
		</div>
	</form>
	<%} %>
</body>
</html>