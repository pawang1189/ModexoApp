<%@page import="com.modexo.controller.*"%>
<jsp:useBean id="bean" class="com.modexo.model.EmployeeDetailsBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>

<%
int i=ModifyEmployee.update(bean);
response.sendRedirect("searchedEmployeeView.jsp");
%>