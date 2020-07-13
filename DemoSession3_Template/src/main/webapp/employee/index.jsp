<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>employee Page</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach var="item" items="${employees}">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.email}</td>
				<td align="center">
				<a href="employee?action=details&id=${item.id}">Details</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href = "demo">Back</a>
</body>
</html>