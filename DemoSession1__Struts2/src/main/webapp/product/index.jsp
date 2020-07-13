<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Product Info</h3>
	id: ${product.id }
	<br>
	name: ${product.name }
	<br>
	price: ${product.price }
	<br>
	
	<h3>Product List</h3>
	<c:forEach var="p" items="${products }">
		id: ${p.id }
		<br>
		name: ${p.name }
		<br>
		price: ${p.price }
		<br>
		================
		<br>
	</c:forEach>
	
	<br>
	<s:a namespace="/demo" action="demo1">Back</s:a>
	
</body>
</html>