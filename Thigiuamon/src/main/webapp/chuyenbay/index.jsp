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
<h3>Danh Sach Chuyen Bay</h3>
<table border="1">
<tr>
	<th>Ma Chuyen bay</th>
	<th>Ten Chuyen Bay</th>
	<th>Ngay di</th>
	<th>Tuy Chon</th>
</tr>
	<c:forEach var="item" items="${ chuyenbays }">
		<tr>
			<td>${ item.macb }</td>
			<td>${ item.tencb }</td>
			<td>${ item.ngaydi }</td>
			<td>
				<a href="chuyenbay?action=edit&macb=${ item.macb }">Cap nhat</a>|
				<a href="chuyenbay?action=viewVe&macb=${ item.macb }">Danh sach ve</a> |
				<a href = "chuyenbay?action=addVe&macb=${item.macb }">Dat Ve</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>