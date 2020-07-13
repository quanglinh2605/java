<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="home">Home</a>
	<a href="aboutus">About Us</a>
	<a href="new">News</a>
	<br>
	<br>
	<jsp:include page="${p}"></jsp:include>
	<br>
	<br> Copyright
</body>
</html>