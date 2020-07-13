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
	Age: ${sessionScope.age }
	<br> Username: ${sessionScope.name}
	<h3>Product Info</h3>
	Id: ${sessionScope.product.id }
	<br> name: ${sessionScope.product.name }
	<br> price: ${sessionScope.product.price}
	<h3>Product List</h3>
	<c:forEach var="product" items="${ sessionScope.products }">
	Id: ${product.id }
 <br>
 name: ${product.name }
 <br>
 price: ${product.price}
<br>
<a href="cart?action=buy&id=${product.id}">Buy Now</a>
<br>
-------------------------
<br>
</c:forEach>
	<form method="post">
		<table>
			<tr>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><input type="submit" name="Save" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>