<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>employee details Page</h3>
<table border="1">
<tr>
	<td>Id</td>
	<td>${employee.id}</td>
</tr>
<tr>
	<td>Name</td>
	<td>${employee.name}</td>
</tr>
<tr>
	<td>Phone</td>
	<td>${employee.phone}</td>
</tr>
<tr>
	<td>Email</td>
	<td>${employee.email}</td>
</tr>
<tr>
	<td>Address</td>
	<td>${employee.address}</td>
</tr>
<tr>
	<td>Salary</td>
	<td>${employee.salary}</td>
</tr>
</table>
<a href="employee?action=list">Back</a>
</body>
</html>