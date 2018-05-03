<%@page import="com.modexo.model.EmployeeDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body background="images/background1.jpg">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.modexo.model.EmployeeDetailsBean"  %>
<%@page import="java.sql.Date"%>
<%
EmployeeDetailsBean bean = (EmployeeDetailsBean) session.getAttribute("searchEmployee");
%>
<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Email</th>
			<th>Employee Contact</th>
			<th>Date of Joining</th>
			<th>Rate Per Hour</th>
			<th>Employee Role</th>
			
		</tr>
		<tr>
		
			<td>
				<%=bean.getEmpid()%>
			</td>
			<td>
				<%=bean.getEmpname()%>
			</td>
			<td>
				<%=bean.getEmpemail()%>
			</td>
			<td>
				<%=bean.getEmpcontact()%>
			</td>
			<td>
				<%=new Date(bean.getEmpdoj().getTime())%>
			</td>
			<td>
				<%=bean.getEmprate()%>
			</td>
			<td>
				<%=bean.getEmprole()%>
			</td>
			
		
		</tr>
		

	</table>
	<br />
	<br />
	<a href="EmployeeHomePageAdmin.jsp">Home Page</a>
	<br />
	<br />
</body>
</html>