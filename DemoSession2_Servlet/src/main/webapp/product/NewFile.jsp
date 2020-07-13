<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
	<h3>Product Info</h3>
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<td>ID</td>
			<td>${product.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${product.name}</td>
		</tr>
		<tr>
			<td>Photo</td>
			<td><img src="assets/image/${product.photo}" width="120"
				height="100"></td>
		</tr>
		<tr>
			<td>Status</td>
			<td>${product.status}</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${product.price}</td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td>${product.quantity}</td>
		</tr>
		<tr>
			<td>Total</td>
			<td>${product.price*product.quantity}</td>
		</tr>
	</table>
	<h3>Product List</h3>
	<table border="1">
		<tr>
			<th>No.</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Status</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub total</th>
			<th>Stock</th>
		</tr>
		<C:set var="total" value="0"></C:set>
		<C:forEach var="p" items="${products}" varStatus="i">
			<C:set var="total" value="${total + p.price*p.quantity}"></C:set>
			<tr>
				<td>${i.index + 1}</td>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td><img src="assets/image/${p.photo}" width="120" height="100"></td>
				<td>${p.status}</td>
				<td>${p.price}</td>
				<td>${p.quantity}</td>
				<td>${p.price*p.quantity}</td>
				<td>
				<C:if test="${p.quantity > 0}">
					In
				</C:if>
				<C:if test="${p.quantity == 0}">
					Out
				</C:if>
				<br>
				<C:choose>
					<C:when test="${p.quantity > 0}">
						In
					</C:when>
					<C:otherwise>
					Out
					</C:otherwise>
				</C:choose>
				</td>
			</tr>
		</C:forEach>
		<tr>
			<td colspan="7" align="right">Total</td>
			<td>${total}</td>
		</tr>
	</table>
</body>
</html>