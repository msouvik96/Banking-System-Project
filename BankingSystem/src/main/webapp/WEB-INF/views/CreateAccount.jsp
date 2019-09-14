<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>

</head>
<body>
	<style>
body{
    margin: 0;
    padding: 0;
    background: url(./resources/Picture/1.jpg);
    background-size: cover;
    background-position: center;
    font-family: sans-serif;
    color:gold;
}
.header{
    text-align: center;
    margin: 0;
    padding: 0;
    width: 1400px;
    height: 80px;
    background-size: cover;
    background-position: center;
}
legend{
    color:greenyellow;
}
p{
    color: rgb(233, 163, 14);
}

 input[type="submit"]
{
    border: none;
    outline: none;
    height: 40px;
    background: #35e01e;
    color: #fff;
    font-size: 18px;
    border-radius: 20px;
}

input[type="submit"]:hover
{
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
			<center>
				<b><b><u>CREATE ACCOUNT</u></b></b>
			</center>
		</h1>
	</div>
	<div>
		<form action="./createaccountm" method="post">
			<fieldset>
				<legend>
					<h2>
						<i><b> Personal Details :</b></i>
					</h2>
				</legend>
				<p style="display: inline-block"><i>Customer Name</i></p>
                <input type="text" name="Customername" placeholder="Enter Customer Name"><br>
                <p style="display: inline-block"><i>Address</i></p>
                <input type="text" name="address" placeholder="Enter Address"><br>
                <p style="display: inline-block"><i>Mobile Number</i></p>
                <input type="text" name="MobileNo" placeholder="Enter Mobile No"><br>
				<p style="display: inline-block">
					<i>Mail Address</i>
				</p>
				<input type="email" name="mail" placeholder="Enter Email" required><br>
				<p style="display: inline-block">
					<i>User ID</i>
				</p>
				<input type="text" name="userid" placeholder="Enter User_ID"
					required><br>
				<p style="display: inline-block">
					<i>Pancard Number</i>
				</p>
				<input type="text" name="pancard" placeholder="Enter Pancard_Number"
					required><br>
				<p style="display: inline-block">
					<i>Sceret Question</i>
				</p>
				<input type="text" name="question"
					placeholder="Enter Sceret_Question" required><br>
			</fieldset>
			<fieldset>
				<legend>
					<h2>
						<i><b>Account Details :</b></i>
					</h2>
				</legend>
				<p style="display: inline-block">
					<i>User Account ID</i>
				</p>
				<input type="text" name="accnumber"
					placeholder="Enter User_Account_ID" required><br>
				<p style="display: inline-block">
					<i>Account Type</i>
				</p>
				<input type="text" name="acctype" placeholder="Enter Account_Type"
					requiredss><br>
				<p style="display: inline-block">
					<i>Account Balance</i>
				</p>
				<input type="text" name="accbalance"
					placeholder="Enter Account_Balance" required><br>
				<p style="display: inline-block">
					<i>User Password</i>
				</p>
				<input type="password" name="password"
					placeholder="Enter UserPassword" required><br>
				<p style="display: inline-block">
					<i>Transaction Password</i>
				</p>
				<input type="password" name="Pass"
					placeholder="Enter Transaction_Password" required><br>

				<p style="display: inline-block">
					<i>Account Open Date</i>
				</p>
				<input type="date" name="day" required><br>
				<p style="display: inline-block">
					<i>Lock Status</i>
				</p>
				<input type="text" name="lockstatus" required> <br>
			</fieldset>
			<br> <br>

			<center>
				<input type="submit" value="Create Account">
			</center>
	</div>
	</form>
	<%} %>
</body>
</html>