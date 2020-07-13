<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Promotion</h3>
<ul>
	<c:forEach var="product" items="${products }">
		<li><img src="${pageContext.request.contextPath }/access/image/${product.photo}" style="width: 120px; height: 100px"></li>
		<li>${product.name }</li>
		<li>${product.price }</li>
	</c:forEach>
</ul>

</body>
</html>