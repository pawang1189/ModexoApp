<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body background="images/background1.jpg">
<body>
	<%@page import="com.modexo.controller.EmployeeDetails"%>
	<%@page import="com.modexo.model.EmployeeDetailsBean"%>
	<jsp:useBean id="obj" class="com.modexo.model.EmployeeDetailsBean" />

	<jsp:setProperty property="*" name="obj" />


	<%
		//setAttribute in clockinoutprocess.jsp
		int empid = (int) session.getAttribute("empid"); //typecasted object to integer

		EmployeeDetailsBean ebean = EmployeeDetails.getEmpDetails(empid);
	%>
	<div style="float: center">
		<h4>Welcome to Employee Portal</h4>
	</div>
	<br></br>
	<form>
		<fieldset>
			<legend>User Details:</legend>
			<div style="float: left">
				Name:<%
				out.print(ebean.getEmpname());
			%>
				<br /> <br /> Employee ID:<%
 	out.print(ebean.getEmpid());
 %><br /> <br /> Contact:
				<%
 	out.print(ebean.getEmpcontact());
 %><br /> <br /> Email:
				<%
 	out.print(ebean.getEmpemail());
 %><br /> <br /> Date of Joining:
				<%
 	out.print(ebean.getEmpdoj());
 %><br /> <br /> Rate Per Hour:
				<%
 	out.print(ebean.getEmprate());
 %><br /> <br />
			</div>
		</fieldset>
		<br /> <br />
	</form>
	<form>
		<fieldset>
			<legend>Shift Details:</legend>
			<br /> Number of hours worked in last 7 days: <input type=""
				name="lastsevendays" value=""><br /> <br /> Number of
			hours worked in last 30 days: <input type="text"
				name="lastthirtydays" value=""><br /> <br /> Number of
			hours worked in this year: <input type="text" name="thisyear"
				value=""><br /> <br /> <br /> <br /> Total Hours worked
			till date : <input type="text" name="totalhours" value=""><br />
			<br /> Rate per hour : <input type="text" name="rate" value=""><br />
			<br /> Total Salary : <input type="text" name="totalsalary" value=""><br />
			<br />
		</fieldset>
	</form>

		<%
String cookieName = "empname";
	String empname="";
	Cookie[] cookies = request.getCookies();
if (cookies != null) {

	for (int i=0;i<cookies.length ;i++)
	{
		if(cookieName.equals(cookies[i].getName())){
			empname=cookies[i].getValue();
		}
	}
}
%>


	<form action="SearchEmployeeProcess.jsp" method="post">
		<fieldset>
			<legend>Search Employee:</legend>
			<br /> Employee Name:<input type="text" name="empname" value="<%=empname%>"><br />
			<br /> <button type="submit">Search</button> <br />
		</fieldset>
	</form>

	<br />
	<br />
	<a href="index.jsp">Logout</a>
	<br />
	<br />
</body>
</html>