<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>List Account</h3>
	<s:form method="post" namespace="/account" action="search">
		<s:textfield name="keyword" label="keyword"></s:textfield>
		<s:submit name="search"></s:submit>
	</s:form>
	<s:a namespace="/account" action="AddNew">Add</s:a>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Userame</th>
				<th>Fullname</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ accounts }">
				<tr>
					<td>${ item.id }</td>
					<td>${ item.username }</td>
					<td>${ item.fullname }</td>
					<td>${ item.status ? "active":"inactive" }</td>
					<td>
						<s:url var="url_Delete" namespace="/account"
							action="delete">
							<s:param name="id">${item.id}</s:param>
						</s:url> <s:a href="%{url_Delete}"
							onclick="return confirm('Are you sure')">Delete</s:a> | <s:url
							var="url_Edit" namespace="/account" action="edit">
							<s:param name="id">${item.id}</s:param>
						</s:url> <s:a href="%{url_Edit}">Edit</s:a> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>