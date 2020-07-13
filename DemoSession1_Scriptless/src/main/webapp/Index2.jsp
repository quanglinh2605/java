<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*"%>
<%@ page import="entities.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Date today = new Date();
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
%>
Today: <%=format.format(today) %>
<br/>
	<%
		student student = new student("st01","name 1","2019-11-11.png",7.8);
	%>
	<h3>Student Info</h3>
	<table border="1">
		<tr>
		<td>Id</td>
		<td><%= student.getId() %>
		</tr>
		
		<tr>
			<td>Name</td>
			<td><%=student.getName() %>
		</tr>
		
		<tr>
		<td>Image</td>
		<td><img src="Assets/Image/<%=student.getPhoto() %>" width="120" height="100"></td>
		</tr>
		
		<tr>
			<td>Score</td>
			<td><%=student.getScore() %></td>
		</tr>
	</table>
</body>
</html>