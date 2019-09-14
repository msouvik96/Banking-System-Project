<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<body>
	<style>
body {
	margin: 0;
	padding: 0;
	background: url(./resources/Picture/AA.jpg);
	background-size: cover;
	background-position: initial;
	font-family: sans-serif;
	color: gold;
}

.header {
	background: url(./resources/Picture/sea.jpg);
	width: 100%;
	height: 30px;
	position: fixed;
	font-size: 25px;
	background-position: center;
	background-size: cover;
	padding: 15px 0;
	color: #fff;
	top: 0;
}

.loginbox {
	width: 400px;
	height: 420px;
	background-color: rgb(11, 92, 119);
	color: #fff;
	top: 55%;
	left: 70%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 50px 30px;
	s
}

.loginimg {
	width: 100px;
	height: 100px;
	border-radius: 60%;
	position: absolute;
	top: -50px;
	left: calc(50% -50px);
}

h1 {
	margin: 0;
	padding: 0 0 20px;
	text-align: center;
	font-size: 22px;
}

.loginbox p {
	margin: 0;
	padding: 0;
	font-weight: bold;
}

.loginbox input {
	width: 100%;
	margin-bottom: 20px;
}

.loginbox input[type="text"], input[type="password"] {
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
}

.loginbox input[type="submit"] {
	border: none;
	outline: none;
	height: 40px;
	background: #35e01e;
	color: #fff;
	font-size: 18px;
	border-radius: 20px;
}

.loginbox input[type="reset"] {
	border: none;
	outline: none;
	height: 40px;
	background: #fa0a3e;
	color: #fff;
	font-size: 18px;
	border-radius: 20px;
}

.loginbox a {
	text-decoration: none;
	font-size: 12px;
	line-height: 20px;
	color: darkgrey;
}

.loginbox a:hover {
	cursor: pointer;
	color: #5d10ec
}

.loginbox input[type="submit"]:hover, input[type="reset"]:hover {
	cursor: pointer;
	background: #5d10ec;
	color: hotpink;
}
</style>
<h1 class="header"></h1>
	<div class="loginbox">
		<img src="./resources/Picture/loginIMG.jpg" alt="img" class="loginimg">
		<h1>User Login</h1>
		<form action="./loginm" method="post">
			<p>UserId</p>
			<input type="text" name="userid" placeholder="Enter UserId"
				required>
			<p>Password</p>
			<input type="password" name="password" placeholder="Enter Password"
				required> <input type="submit" value="Login"> <input
				type="reset" value="Reset"> <!-- <a href="#">Forget Password</a> -->
		</form>
	</div>
</body>
</html>