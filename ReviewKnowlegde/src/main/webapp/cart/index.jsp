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
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${ sessionScope.products }">
				<tr>
					<td>${ product.id }</td>
					<td>${ product.name }</td>
					<td>${ product.price}</td>
					<td><a href="cart?action=buy&id=${ product.id }">Buy</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>