<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Invoice Info</h3>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>${invoice.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${invoice.name}</td>
		</tr>
		<tr>
			<td>Created</td>
			<td>${invoice.created}</td>
		</tr>
		<tr>
			<td>Payment</td>
			<td>${invoice.payment}</td>
		</tr>
	</table>
	<h3>Customer Info</h3>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>${invoice.customer.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${invoice.customer.name}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${invoice.customer.address}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${invoice.customer.email}</td>
		</tr>
	</table>
	<h3>Product List</h3>
	<table border="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Photo</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>status</th>		
	</tr>	
	<c:forEach var = "item" items="${ invoice.products}">
		<tr>
		<td>${item.id }</td>
		<td>${item.name}</td>
		<td><img src="assets/image/${item.photo}" width=120 height=100></td>
		<td>${item.price}</td>
		<td>${item.quantity}</td>
		<td>${item.status}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>