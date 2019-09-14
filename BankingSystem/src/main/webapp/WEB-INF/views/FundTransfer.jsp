<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fund Transfer</title>

</head>
<body>
	<style>
div {
	position: absolute;
	left: 500px;
	top: 250px;
	height: 200px;
	width: 300px;
     background-color: rgba(201, 206, 205, 0.37);
	box-align: centre;
	right: 20px;
	padding-top: 80px;
	border-radius: 40px;
	border-spacing: 30px;
	padding-left: 50px;
	border: 20px;
	padding-bottom: 30px;
}

body {
	background-image: url("./resources/Picture/mqw.jpg");
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
	font-size: 15px;
	left: 100px;
	right: 300px;
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

h3 {
	top: 800px;
	font-size: 35px;
	color: darkcyan;
}
h1
{ 
 direction:centre;
}
</style>


	<%
		if (session == null) {
			response.sendRedirect("./loginpage");
		} else {
	%>
	

	
	
	<br>
	<h1>
		<h1>
			<b><center>
					<u> Codex Bank</u>
				</center></b>
		</h1>
	</h1>
	<br>
	<br>
	
	<h1>
		<h1>
			<b><center>
					Transfer Amount
				</center></b>
		</h1>
	</h1>
	<br>
	<br>

	<form action="./fundtransferm" method="POST">
		<!-- <h2>
			<center>
				<br> FUND TRANSFER <br> <br>
			</center>
		</h2> -->

		<div>
			<center>
				<br> <label for="toacnt">To Account Id:&nbsp &nbsp</label> <input
					type="number" name="toaccount_id"  placeholder="Enter Account Id"id="toacnt" required><br> <br>
				Date Of Transfer: <input type="date" name="date" required><br> <br>
				<label for="acntid">Amount: &nbsp &nbsp &nbsp &nbsp &nbsp </label> <input
					type="number" name="amount" id="acntid" placeholder="Enter Amount" required> <br> <br>
				<br> <input type="submit" value="SUBMIT"> &nbsp &nbsp
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
				&nbsp &nbsp <input type="reset" value="RESET"><br>

			</center>
		</div>
	</form>

	<%
		}
	%>
</body>
</html>