<%@page import="com.modexo.controller.DeleteEmployee"%>
<%@page import="com.modexo.*"%>
<jsp:useBean id="bean" class="com.modexo.model.EmployeeDetailsBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>

<%
DeleteEmployee.deleteEmployee(bean);
response.sendRedirect("ViewEmployees.jsp");
%>