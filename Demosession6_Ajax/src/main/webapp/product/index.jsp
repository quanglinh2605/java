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
<h3>Search Result</h3>
<table border="1">
<thead>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Price</th>
</tr>
</thead>
<tbody>
	<c:forEach var="product" items="${ products }">
		<tr>
			<td>${ product.id }</td>
			<td>${ product.name }</td>
			<td>${ product.price }</td>
		</tr>	
	</c:forEach>
</tbody>
</table>
</body>
</html>