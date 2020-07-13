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
	<h3>Cart</h3>
	<form method="post" action="cart">
		<table border="1">
			<thead>
				<tr>
					<th>Action</th>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity <c:if test="${ sessionScope.cart != null && sessionScope.cart.size() > 0 }"><input type="submit" value="Update"></c:if></th>
					<th>Sub Total</th>
				</tr>
			</thead>
			<tbody>
				<c:set value="0" var="total"></c:set>
				<c:forEach var = "item" items="${ sessionScope.cart }" varStatus="i">
					<c:set var="total" value="${ total + item.product.price * item.quantity }"></c:set>
					<tr>
						<td><a href="cart?action=remove&index=${ i.index }">Remove</a></td>
						<td>${ item.product.id }</td>
						<td>${ item.product.name }</td>
						<td>${ item.product.price }</td>
						<td align="center"><input type = "number" value="${ item.quantity }" name="quantity" min="1" style="width:50px;"></td>
						<td>${ item.product.price * item.quantity }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">Total</td>
					<td><c:out value="${ total }"></c:out></td>
				</tr>				
			</tbody>
		</table>
	</form>
	<br><br>
	<a href="cart">Continue Shopping</a>
</body>
</html>