<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="com.modexo.controller.LoginOut"%>
	<%@page import="com.modexo.model.UserBean"%>
	<jsp:useBean id="obj" class="com.modexo.model.UserBean" />

	<jsp:setProperty property="*" name="obj" />

	<%
		boolean status = LoginOut.validate(obj);
		if (status) {
			
			Cookie empidCookie = new Cookie(obj.getEmpid(), obj.getEmpid());
			empidCookie.setMaxAge(60 * 60 * 24 * 365); // 1 year
			response.addCookie(empidCookie);

			session.setAttribute("session", "TRUE");
			session.setAttribute("empid", Integer.parseInt(obj.getEmpid()));
			
			if (obj.getRole().equals("E")){
				response.sendRedirect("EmployeeHomePage.jsp");	
			}
			else{
				response.sendRedirect("EmployeeHomePageAdmin.jsp");
			}
			
		} else {
			out.print("Sorry, Employee ID or Password is incorrect");
		}
	%>

	<br>
	<br />
	<a href="index.jsp">Back</a>
	<br />
	<br />
</body>
</html>

