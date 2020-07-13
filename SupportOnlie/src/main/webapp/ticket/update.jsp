<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Update Ticket</h3>
<form action="ticket?action=update" method="post">
	<table>
		<tr>
			<td>Title</td>
			<td><input type="text" name="title"  value="${ticket.title}"></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><textarea name="description">${ticket.description}</textarea></td>
		</tr>
		<tr>
			<td>Priority</td>
			<td>
				<select name="priority">
				<option value="High" ${ticket.priority == "High" ? 'selected':''}>High</option>
				<option value="Urgent" ${ticket.priority == "Urgent" ? 'selected':''}>Urgent</option>
				<option value="Medium" ${ticket.priority == "Medium" ? 'selected':''}>Medium</option>
				<option value="Low" ${ticket.priority == "Low" ? 'selected':''}>Low</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Status</td>
			<td>
				<select name="status">
				<option value="In Progess" ${ticket.status == "In Progress" ? 'selected':''}>In Progess</option>
				<option value="Pending" ${ticket.status == "Pending" ? 'selected':''}>Pending</option>
				<option value="Solved" ${ticket.status == "Solved" ? 'selected':''}>Solved</option>
				<option value="Closed" ${ticket.status == "Closed" ? 'selected':''}>Closed</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Created Date
				<fmt:formatDate var="date" value="${ticket.created}" pattern="yyyy-MM-dd"/>
			</td>
			<td><input type="date" name="created" value="${date}"></td>
		</tr>
		<tr>
			<td>&nbsp;<input type="hidden" name="id" value="${ticket.id}"></td>
			<td><input type="submit" value="Save"></td>
		</tr>
	</table>
</form>
</body>
</html>