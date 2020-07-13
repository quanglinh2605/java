<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="account">Login</a> |
	<a href="photo">Photo</a> |
	<a href="question">Questions</a> |
	<a href="cart">Product Cart</a> |
	<a href="ajax">Product ajax</a> |
	<a href="custom">Custom</a> |
	<a href="locale">Locale</a>
	<br>
	<br>
	<jsp:include page="${ p }"></jsp:include>
	<br>
	<br> Copyright
</body>
</html>