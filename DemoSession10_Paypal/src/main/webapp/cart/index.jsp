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
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Photo</th>
				<th>Quantity</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ cart }">
				<tr>
					<td>${ item.product.id }</td>
					<td>${ item.product.name }</td>
					<td>${ item.product.price }</td>
					<td><img
						src="${ pageContext.request.contextPath }/assets/images/${ item.product.photo }"
						width="120" height="100" /></td>
					<td>${ item.quantity }</td>
					<td>${ item.quantity*item.product.price }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form method="post" action="${ initParam['posturl'] }">
		<!-- Setting -->
		<input type="hidden" name="upload" value="1">
		<input type="hidden" name="cmd" value="_cart">
		<input type="hidden" name="business" value="${ initParam['business'] }">
		<input type="hidden" name="return" value="${ initParam['returnurl'] }">
		<!-- Products -->
		<input type="submit" value="Checkout">
		<c:forEach var="item" items="${ cart }" varStatus="i">
			<input type="hidden" name="item_number_${ i.index+1 }" value="${ item.product.id }">
			<input type="hidden" name="item_name_${ i.index+1 }" value="${ item.product.name }">
			<input type="hidden" name="amount_${ i.index+1 }" value="${ item.product.price }">
			<input type="hidden" name="quantity_${ i.index+1 }" value="${ item.quantity }">			
		</c:forEach>
	</form>
</body>
</html>