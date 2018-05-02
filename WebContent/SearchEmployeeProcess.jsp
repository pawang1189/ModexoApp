<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="com.modexo.controller.SearchEmployee"%>
	<%@page import="com.modexo.model.EmployeeDetailsBean"%>
	<jsp:useBean id="obj" class="com.modexo.model.EmployeeDetailsBean" />

	<jsp:setProperty property="*" name="obj" />

	<%
		Cookie c = new Cookie("empname", obj.getEmpname());
		c.setMaxAge(60 * 60 * 24 * 7); // One week
		response.addCookie(c);
	%>

	<%
		EmployeeDetailsBean bean = SearchEmployee.searchEmployee(obj);
		session.setAttribute("searchEmployee", bean);
		response.sendRedirect("searchedEmployeeView.jsp");
		//out.println("<meta http-equiv='refresh' content='30;URL=index.jsp'>"); //redirects after 3 seconds

		//Meta refresh is a method of instructing a web browser to automatically refresh the current web page or frame after a given time interval, 
		//using an HTML meta element with the http-equiv parameter set to " refresh " and a content parameter giving the time interval in seconds.
	%>


</body>
</html>