<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- <%@ include file="index.jsp"%> -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Log In</title>

</head>

<body>
	<%@page import="com.modexo.controller.LoginOut"%>
	<%@page import="com.modexo.model.UserBean"%>
	<jsp:useBean id="obj" class="com.modexo.model.UserBean" />

	<jsp:setProperty property="*" name="obj" />

	<hr />
<body background="images\background1.jpg">
	<h3>Log In/Log Out</h3>

	<br />
	<form action="LoginLogoutServlet" method="post">

		Employee ID:<input type="text" name="empid"
			value="<%Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
				//	if (c.getName() != null && c.getValue() != null) {
				//		if ((Integer.parseInt(c.getName()) == Integer.parseInt(obj.getEmpid()))) {
							out.print(c.getValue());

							break;
				//		}
				//	}
				}
			}%>" /><br />
		<br /> Password:<input type="password" name="emppassword" /><br />
		<br /> Employee:<input type="radio" name="role" value="E" /><br />
		<br /> Admin:<input type="radio" name="role" value="A" /><br /> <br />
		<input type="submit" value="OK" />
	</form>

</body>
</html>