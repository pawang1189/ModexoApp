<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- <%@ include file="index.jsp"%> -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Clock In Or Clock Out</title>

</head>

<body>
	<hr />
<body background="images\background1.jpg">

	<p style="text-align: center; width: 100%;">
		<img id="logo" src="images\ucmt.png" alt="UCM Logo">
	</p>
	<br />
	<center>

		<form style="align: center; width: 50%"
			action="ClockInClockOutServlet" method="POST">
			<fieldset style="border: solid red;">
				<legend style="font-size: 22px; color: red">Clock In/Clock
					Out</legend>
					<div >
				Employee ID:<input type="text" name="empid" /><br /> <br />
				Password:<input type="password" name="emppassword" /><br /> <br />
				</div>
				<input type="submit" value="Clock In/Out" />
			</fieldset>
		</form>
	</center>

</body>
</html>

































<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- <%@ include file="index.jsp"%> -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Clock In Or Clock Out</title>

</head>

<body>
	<hr />
<body background="images\background1.jpg">
	<h3>Clock In/Out</h3>

	<br />
	<form action="clockinclockoutprocess.jsp" method="post">
		Employee ID:<input type="text" name="empid" /><br /> <br />
		Password:<input type="password" name="emppassword" /><br /> <br />
		<input type="submit" value="OK" />
		<a href="index.jsp" style="margin-right: 50px;">Go Back</a><br/><br/>
	</form>

</body>
</html> --%>