<%@page import="com.modexo.model.EmployeeDetailsBean"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customers</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page import="com.modexo.db.*"%>
	<%@page import="com.modexo.controller.*"%>
	<%@page import="java.util.*"%>


	<h1>Employee List</h1>


	<%
List<EmployeeDetailsBean> list=ViewAllEmployees.getAllRecords();
request.setAttribute("list",list);

%>

	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Email ID</th>
			<th>Date of Joining</th>
			<th>Rate Per Hour</th>
			<th>Role</th>
			<th>Modify</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="bean">
			<tr>
				<td>${bean.empid}</td>
				<td>${bean.empname}</td>
				<td>${bean.empcontact}</td>
				<td>${bean.empemail}</td>
				<td><fmt:formatDate pattern = "yyyy-MM-dd" type = "both" value = "${bean.empdoj}" /></td>
				<td>${bean.emprate}</td>
				<td>${bean.emprole}</td>
				<td>
				<a href="ModifyEmployee.jsp?id=${bean.empid}">Modify</a>
				</td>
				<td><a href="deleteEmployee.jsp?id=${bean.empid}">Delete</a></td>
				
			</tr>
		</c:forEach>
		<c:if test="${list.isEmpty()}">
No records found!
</c:if>
	</table>

	<br />
	<a href="EmployeeHomePageAdmin.jsp">Go Back</a>

</body>
</html>