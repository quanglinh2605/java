<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h3>Student Info</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Score</th>
			<th>Description</th>
		</tr>
		<tr>
			<td>${student.id }</td>
			<td>${student.name }</td>
			<td>${student.score }</td>
			<td>${student.description }</td>
		</tr>
	</table>
	<br>
	<s:a namespace="/student" action="index">Back</s:a>

</body>
</html>