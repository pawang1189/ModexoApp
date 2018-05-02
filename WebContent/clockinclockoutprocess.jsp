<%@page import="java.sql.Time"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%@page import="com.modexo.controller.ClockInOut"%>
	<%@page import="com.modexo.model.UserBean"%>
	<jsp:useBean id="obj" class="com.modexo.model.UserBean" />

	<jsp:setProperty property="*" name="obj" />

	<%
		boolean status = ClockInOut.validate(obj);
		if (status) {
			session.setAttribute("session", "TRUE");
			session.setAttribute("empid", Integer.parseInt(obj.getEmpid())); //getAttribute in EmployeeHomePage.jsp
			ClockInOut.ClockInOutEntryStatus(obj);
			ClockInOut.ClockInOutEntryStatusRecords(obj);
			
			
			out.println("<meta http-equiv='refresh' content='3;URL=clockinclockout.jsp'>"); //redirects after 3 seconds
			out.println("<p style='color:green;'>Your Shift starts now..Have a great time</p>");
			//Meta refresh is a method of instructing a web browser to automatically refresh the current web page or frame after a given time interval, 
			//using an HTML meta element with the http-equiv parameter set to " refresh " and a content parameter giving the time interval in seconds.
			
			
	%>
	
	
	<%
		//response.sendRedirect("clockinclockout.jsp");

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

