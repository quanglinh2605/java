<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Add Ticket</h3>
<form action="ticket?action=add" method="post">
	<table>
		<tr>
			<td>Title</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><textarea name="description"></textarea></td>
		</tr>
		<tr>
			<td>Priority</td>
			<td>
				<select name="priority">
				<option value="High" selected>High</option>
				<option value="Urgent">Urgent</option>
				<option value="Medium">Medium</option>
				<option value="Low">Low</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Status</td>
			<td>
				<select name="status">
				<option value="In Progess" selected>In Progess</option>
				<option value="Pending">Pending</option>
				<option value="Solved">Solved</option>
				<option value="Closed">Closed</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Created Date</td>
			<td><input type="date" name="created"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Save"></td>
		</tr>
	</table>
</form>
</body>
</html>