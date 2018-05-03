<%@page import="java.sql.Date"%>
<%@page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>ModexoApp</title>

<body background="images/background1.jpg">
	<%@page import="com.modexo.controller.EmployeeDetails"%>
	<%@page import="com.modexo.model.EmployeeDetailsBean"%>
	<%@page import="com.modexo.controller.EmpolyeeWorkDeails"%>
	<jsp:useBean id="obj" class="com.modexo.model.EmployeeDetailsBean" />

	<jsp:setProperty property="*" name="obj" />



	<%
		//setAttribute in clockinoutprocess.jsp
		int empid = (int) session.getAttribute("empid"); //typecasted object to integer
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 

		EmployeeDetailsBean ebean = EmployeeDetails.getEmpDetails(empid);
		Date joiningDate = new Date(ebean.getEmpdoj().getTime());
		double ratePerHr = ebean.getEmprate();
		double sevenDaysWork = EmpolyeeWorkDeails.getEmpWorkDetails(empid, 7);
		double monthlyWork = EmpolyeeWorkDeails.getEmpWorkDetails(empid, 30);
		double yearlysWork = EmpolyeeWorkDeails.getEmpWorkDetails(empid, 365);
		double totlHours = EmpolyeeWorkDeails.getTotalWorkHours(empid, joiningDate);
	%>
	<p style="text-align: center; width: 100%;">
		<img id="logo" src="images\ucmt.png" alt="UCM Logo"">
	</p>
	<br />
	<br />
	<div
		style="float: center; color: red; font-size: 26px; text-align: center;">
		<h4>Welcome to Employee Portal</h4>
	</div>
	<br></br>
	<form style=" width: 40%; align:center">
		<fieldset>
			<legend>User Details:</legend>
			<div style="float: left; width: 40%">
								Name:<%
								out.print(ebean.getEmpname());
							%>
								<br /> <br /> Employee ID:<%
				 	out.print(ebean.getEmpid());
				 %><br /> <br />
								Contact:
								<%
				 	out.print(ebean.getEmpcontact());
				 %><br /> <br /> Email:
								<%
				 	out.print(ebean.getEmpemail());
				 %><br /> <br /> Date of Joining:
								<%
				 	out.print(new Date(ebean.getEmpdoj().getTime()));
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
				name="lastsevendays" value="<% out.print(sevenDaysWork);%>"><br /> <br /> Number of
			hours worked in last 30 days: <input type="text"
				name="lastthirtydays" value="<%  out.print(monthlyWork);%>"><br /> <br /> Number of
			hours worked in this year: <input type="text" name="thisyear"
				value="<%  out.print(yearlysWork);%>"><br /> <br /> <br /> <br /> Total Hours worked
			till date : <input type="text" name="totalhours" value="<%  out.print(totlHours);%>"><br />
			<br /> Rate per hour : <input type="text" name="rate" value="<%  out.print(totlHours);%>"><br />
			<br /> Total Salary : <input type="text" name="totalsalary" value="<%  out.print("$"+totlHours*ratePerHr);%>"><br />
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
	
	<form action="AddEmployees.jsp" method="post">
		<fieldset>
			<br /> <button type="submit">Add New Employee</button> <br />
		</fieldset>
	</form>
	
	<form action="ViewEmployees.jsp" method="post">
		<fieldset>
			<br /> <button type="submit">View All Employee</button> <br />
		</fieldset>
	</form>

	<br />
	<br />
	
	<a href="index.jsp">Logout</a>
	<br />
	<br />
</body>
</html>