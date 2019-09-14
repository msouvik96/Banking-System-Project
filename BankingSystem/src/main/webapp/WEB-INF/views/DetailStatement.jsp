<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request for Detail Statement</title>
</head>
<body>
	<style>
div {
	border-top-width: 20%;
	position: absolute;
	left: 500px;
	top: 200px;
	height: 200px;
	width: 320px;
	/*  background-color: sandybrown; */
	background-color: rgba(201, 206, 205, 0.37);
	box-align: centre;
	right: 110px;
	padding-top: 80px;
	border-radius: 40px;
	border-spacing: 30px;
}

body {
	background-image: url("./resources/Picture/peop.jpg");
	background-size: cover;
}

h2 {
	background-color: text-align: center;
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

.q {
	font-size: 18px;
}
</style>


	<%if (session==null)
{
	response.sendRedirect("./loginpage");
}
else
{%>

	<br>
	<br>
	<h1>
		<h1>
			<b><center>
					<u> Codex Bank</u>
				</center></b>
		</h1>
	</h1>

	<h2>
		<center>
			<br> Request Detailed Statement <br> <br>
		</center>
	</h2>
	<form action="./detailstatementm" method="get">


		<div>
			<center>
				<label for="fromdate">From Date: &nbsp &nbsp </label> <input
					type="date" name="fromdate" id="fromdate" required><br>
				<br> <label for="todate">To Date :&nbsp &nbsp&nbsp
					&nbsp &nbsp &nbsp </label> <input type="date" name="todate" id="todate"
					required> <br> <br> <input type="submit"
					value="SUBMIT"> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <input type="reset"
					value="RESET"><br>

			</center>
		</div>
	</form>
	<%} %>
</body>
</html>