<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Scriptless</h3>
	<%
		String username = "abc";
		int age = 20;
		double price = 4.5;
		boolean status = true;
		out.print("Username: " + username);
		out.print("<br>" +"Age: " + age);
		out.print("<br>" + "status: " + status);
		out.print("<br>" + "Price: " + price);
	%>
	
	<br/>
	username: <%=username %>
	<br>
	age: <%= age %>
	<br/>
	price: <%=price %>
	<br>
	status: <%=status %>
	<br>
	<%
		String photo = "2019-10-20 (6).png";
		int width = 120;
		int height = 100;
	%>
	<img src="Assets/Image/<%=photo %>" width="<%=width %>" height="<%=height %>">
</body>
</html>