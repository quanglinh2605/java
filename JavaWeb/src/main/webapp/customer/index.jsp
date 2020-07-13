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
	<h3>List Customer</h3>
	<a href="customer?action=add">Add</a>
	<c:if test="${ customers != null }">
		<table border="1">
			<tr>
				<th>Customer ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Birthday</th>
				<th>Phone</th>
				<th>Options</th>
			</tr>
			<c:forEach var="item" items="${ customers }">
				<tr>
					<td>${ item.id }</td>
					<td>${ item.name }</td>
					<td>${ item.address }</td>
					<td>${ item.birthday }</td>
					<td>${ item.phone }</td>
					<td><a href="customer?action=addorder&id=${ item.id}">Add New Order</a>| <a
						href="customer?action=vieworder&id=${ item.id }">View Orders</a>| <a
						href="customer?action=edit&id=${ item.id }">Change Profile</a>|</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>