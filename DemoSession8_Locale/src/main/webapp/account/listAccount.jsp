<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>List Account</h3>
<a href="${ pageContext.request.contextPath }/account?action=register">Add</a>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Username</th>
		<th>Fullname</th>
		<th>Action</th>
	</tr>
	<c:forEach var="account" items="${ accounts }">
		<tr>
			<td>${ account.id }</td>
			<td>${ account.username}</td>
			<td>${ account.fullname}</td>
			<td>
				<a href="account?action=edit&id=${ account.id }">Edit</a>|
				<a href="account?action=delete&id=${account.id}">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>