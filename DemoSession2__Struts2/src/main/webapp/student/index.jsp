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
	<h3>Search</h3>
	<s:form method="post" namespace="/student" action="search">
		<s:textfield label="Keyword" name="keyword"></s:textfield>
		<s:submit value="Search"></s:submit>
	</s:form>
	
	<h3>Student List</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Score</th>
		</tr>
		<c:forEach var="student" items="${students }">
			<tr>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td>${ student.description }</td>
				<td>${ student.score }</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>