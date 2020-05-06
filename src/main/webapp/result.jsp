<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h1>JSP - JavaServer Pages</h1>
	<%
		User user = (User) request.getAttribute("employee");
		out.println("Welcome " + user.getUsername() + "--your passord is " + user.getDateOfBirth());
	%>

	<br>
	<h1>${user1}</h1>
	<br>
	<h1>${pass1}</h1>

</body>
</html>