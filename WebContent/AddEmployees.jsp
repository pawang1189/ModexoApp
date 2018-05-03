<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- <%@ include file="index.jsp"%> -->


<!DOCTYPE html >
<html>
<head>
<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>CustomerPage</title>

</head>

<body>
	<hr />
<body background="images\background1.jpg">
	<h3>Employee Registration :</h3>

	<br />
	<form action="AddEmployeesProcess.jsp" method="get">
	<br />
		
		<br /> Name:<input type="text" name="empname" /><br />
		<br /> Email:<input type="text" name="empemail" /><br />
		<br /> Contact:<input type="text" name="empcontact"/><br />
		<br /> Date Of Joining:<input type="date" name="empdoj"/><br />
		<br /> Password:<input type="text" name="emppassword"/><br />
		<br /> Rate Per Hour:<input type="text" name="emprate"/><br />
		
		<br /> Role of Admin:<input type="radio" name="emprole" value="1"  /><br /> <br />
		<br /> Role of Employee:<input type="radio" name="emprole" value="0"  /><br /> <br />
		<br />
		<input type="submit" value="Register Employee" />
	</form>

</body>
</html>