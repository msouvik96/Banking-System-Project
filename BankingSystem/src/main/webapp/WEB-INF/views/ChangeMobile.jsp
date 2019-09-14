<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Mobile No</title>
<!--  <link rel="stylesheet" href="./ChangeMobile.css"> -->
</head>
<body>
	<style>
div {
	position: absolute;
	left: 659px;
	top: 200px;
	height: 160px;
	width: 200px;
	background-color:brown;
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
	background-image: url("./resources/Picture/ee.png");
	background-size: cover;
}

}
.header {
	 text-decoration-color: lightblue;; 
}
h2
{
text-decoration-color: grey;
font-size: 35px;
	 color: lightblue;
}
 input type=number
 {
 font-size: 50px;
 }
h1
{
right:40px;
color:yellow;
}


h3 {
	top: 800px;
	font-size: 35px;
	color: darkcyan;
}

.x {
	font-size: 20px;
}
</style>

	<%
		if (session == null) {
			response.sendRedirect("./loginpage");
		} else {
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
	
	<h2>
		<h2>
			<b><center>
					Request For Change Mobile No
				</center></b>
		</h2>
	</h2>
	<br>
	<br>



	<form action="./changemobnom" method="post">
		<div>
			<center>
				<label for="mobile">Mobile No:</label> <input type="number"
					name="mobile_No" id="mobile" required placeholder="Enter New Mobile No"><br> <br> <input
					type="submit" value="UPDATE" >  &nbsp &nbsp &nbsp
				&nbsp &nbsp &nbsp <input type="reset"
					value="RESET"><br>

			</center>
		</div>



	</form>
	<%
		}
	%>
</body>
</html>