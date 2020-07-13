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
	
	
	<h3>Student List</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="student" items="${students }">
			<tr>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td>
					<s:url var="details" namespace="/student" action="details">
						<s:param name="id">${student.id }</s:param>
					</s:url>
					<s:a href="%{details}">Details</s:a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>