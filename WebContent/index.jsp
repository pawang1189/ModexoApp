<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body background="images\background1.jpg">

<head>

<link type="text/css" rel="stylesheet" href="stylesheet.css"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Modexo</title>

</head>

<body>
    <a href="clockinclockout.jsp" style="margin-right: 50px;">Clock In/Clock Out</a><br/><br/>
    <a href="loginlogout.jsp">Log In</a><br/><br/>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body background="images\background1.jpg">
<head>

<link type="text/css" rel="stylesheet" href="stylesheet.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Modexo</title>

</head>

<body>

	<p style="text-align:center; width:100%;" ><img id="logo" src="images\ucmt.png" alt="UCM Logo" "></p>
	<br />
	<form style="text-align: center; "
		action="clockinclockout.jsp">
		<fieldset style="border: solid red;">
			<legend  style="font-size: 22px; color: red">Check In/Check Out</legend>
			<input type="submit" name="clockin" value="Clock In/ Clock Out" />

		</fieldset>
	</form>
	<br />
	<br />

	<form style="text-align: center; height: 300px"
		action="loginlogout.jsp">
		<fieldset style="border: solid red;">
			<legend  style="font-size: 22px; color: red">Login</legend>
			<input type="submit" name="login" value="	Login	" />

		</fieldset>
	</form>
</body>
</html>