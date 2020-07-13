<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String username = request.getAttribute("username").toString();	
	int age = Integer.parseInt(request.getAttribute("age").toString());
	double price = Double.parseDouble(request.getAttribute("price").toString());
	boolean status = Boolean.parseBoolean(request.getAttribute("status").toString());
	int quantity = Integer.parseInt(request.getAttribute("quantity").toString());
	%>
	<h3>Scriptless</h3>
	Username: <%=username %><br>
	Age: <%=age%><br>
	Price: <%=price%><br>
	Status: <%=status ? "show":"hide" %><br>
	Total: <%=quantity*price %><br>
	<h3>EL (Expression Language)</h3>
	Username: ${ username}
	<br>
	age: ${age}
	<br>
	price: ${price}
	<br>
	status: ${status ? "show":"hide"}
	<br>
	total: ${price * quantity }
</body>
</html>