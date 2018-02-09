<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add.jsp</title>
</head>
<body bgcolor="Yellow">
	<center>
		<%!int result = 0;%>
		<br>
		<br>
		<%
			int a = Integer.parseInt(request.getParameter("t1"));
			int b = Integer.parseInt(request.getParameter("t2"));
			result = a + b;
		%>
		Todays Date:<%out.println(new Date()); %>
		<h1>Addition of Two Numbers is</h1>
		<h3>
			<%=result%>
		</h3>
	</center>
</body>
</html>