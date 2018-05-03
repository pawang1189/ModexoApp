<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/background1.jpg">
<body>

	<%@page import="com.modexo.controller.*"%>
	<%@page import="com.modexo.db.*"%>
	<jsp:useBean id="obj" class="com.modexo.model.EmployeeDetailsBean" />

	<jsp:setProperty property="*" name="obj" />
	
	<%
	obj.setEmpdoj(request.getParameter("empdoj"));
	out.print(obj.getEmpdoj());
	
	//out.print(obj.toString());
	AddEmployee.InsertEmployees(obj);
	out.println("<meta http-equiv='refresh' content='300;URL=EmployeeHomePageAdmin'>"); //redirects after 3 seconds
	out.println("<p style='color:green;'>Employee has been registered successfully</p>");
	//Meta refresh is a method of instructing a web browser to automatically refresh the current web page or frame after a given time interval, 
	//using an HTML meta element with the http-equiv parameter set to " refresh " and a content parameter giving the time interval in seconds.
	
	
	%>
 <a href="EmployeeHomePageAdmin.jsp">Go Back</a><br/><br/>
</body>
</html>