<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="./ServiceRequest.css"> -->
<title>Service Request</title>
<body>
	<style>
div {
	border-top-width: 20%;
	position: absolute;
	left: 500px;
	top: 190px;
	height: 240px;
	width: 390px;
	/* background-color: light-brown; */
	background-color: rgba(201, 206, 205, 0.37);
	box-align: centre;
	right: 110px;
	padding-top: 80px;
	border-radius: 40px;
	border-spacing: 30px;
}

body {
	background-image: url(" ./resources/Picture/service.jpg");
	background-size: cover;
}

h2 {
	background-image: url(.);
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
	padding-left: 90px;
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

.s {
	background-color: light-blue;
	border: none;
	outline: none;
	height: 40px;
	font-size: 18px;
	border-radius: 20px;
}
</style>

	<%
		if (session == null) {
			response.sendRedirect("./UserLogin.jsp");
		} else {
	%>
	
	
	<h1>
		<h1>
			<b><center>
					<u> CODEX BANK</u>
				</center></b>
		</h1>
	</h1>
<br>
	<br> 
	<h1>
		<h1>
			<b><center>
					Request for Services
				</center></b>
		</h1>
	</h1>

	<form action="./servicerequestm " method="post">

		<div>
			<br> <br> <label for="desription">Service
				Desription:</label> <input type="text" name="Service_Description"
				id="desription" required placeholder="Enter Description"><br> <br> <label
				for="date">Service Raised Date: </label> <input type="date"
				name="Service_Raised_Date" id="date" required><br> <br>
			<label for="status">Service Status :&nbsp &nbsp &nbsp &nbsp </label>
			<input type="text"name="service_status" placeholder="Enter Status" id="status" required><br> <br>
				
			<br> &nbsp &nbsp &nbsp 
				 <input type="submit" value="REQUEST"></input>&nbsp &nbsp &nbsp &nbsp &nbsp
				<input type="reset" value="RESET">
		</div>

		<!-- <p>
			Our Members Are the<br>&nbsp &nbsp &nbsp &nbsp Mission
		</p> -->
	</form>
	<%
		}
	%>
</body>
<footer> </footer>
</html>  