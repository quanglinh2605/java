<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<student> students = new ArrayList<student>();
		students.add(new student("st01", "name 1", "2019-11-11.png", 7.8));
		students.add(new student("st01", "name 1", "2019-11-11.png", 6.7));
		students.add(new student("st01", "name 1", "2019-11-11.png", 8.4));
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Score</th>
		</tr>
		<%for(student student : students) {%>
			<tr>
				<td><%= student.getId() %></td>
				<td><%= student.getName() %></td>
				<td><img src="Assets/Image/<%=student.getPhoto() %>" width="120" height="100"></td>
				<td><%=student.getScore() %></td>
			</tr>
			<%} %>
	</table>
</body>
</html>