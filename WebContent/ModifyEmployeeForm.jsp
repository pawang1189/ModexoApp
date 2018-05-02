<!DOCTYPE html>
<%@page import="com.modexo.controller.ModifyEmployee"%>
<%@page import="com.modexo.model.EmployeeDetailsBean"%>
<%@page import="com.modexo.controller.EmployeeDetails"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
<%@page import="com.modexo.*"%>

<%
String empid=request.getParameter("empid");
EmployeeDetailsBean bean=ModifyEmployee.getRecordById((empid));
%>

<h1>Edit Form</h1>
<form action="ModifyEmployee.jsp" method="post">
<input type="hidden" name="empid" value="<%=bean.getEmpid()%>"/>
<table>
<tr><td>Employee ID:</td><td><input type="text" name="empid" value="<%= bean.getEmpid()%>"/></td></tr>
<tr><td>Employee Name:</td><td><input type="text" name="empname" value="<%= bean.getEmpname()%>"/></td></tr>
<tr><td>Employee Email:</td><td><input type="text" name="empemail" value="<%= bean.getEmpemail()%>"/></td></tr>
<tr><td>Employee Contact:</td><td><input type="text" name="empcontact" value="<%= bean.getEmpcontact()%>"/></td></tr>
<tr><td>Date of Joining:</td><td><input type="text" name="empdoj" value="<%= bean.getEmpdoj()%>"/></td></tr>
<tr><td>Rate Per Hour:</td><td><input type="text" name="emprate" value="<%= bean.getEmprate()%>"/></td></tr>
<tr><td>Employee Role:</td><td><input type="text" name="emprole" value="<%= bean.getEmprole()%>"/></td></tr>



<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>
</table>
</form>

</body>
</html>