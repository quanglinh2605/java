<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<%
	List<Product> products = new ArrayList<Product>();
	products.add(new Product("p01", "name 1", "2019-11-11.png", 10.5, 5 , true));
	products.add(new Product("p02", "name 2", "2019-11-11.png", 15, 3 , true));
	products.add(new Product("p03", "name 3", "2019-11-11.png", 8.5, 4 , false));
	products.add(new Product("p04", "name 4", "2019-11-11.png", 12.5, 2 , false));
	double S = 0;
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Status</th>
			<th>Total</th>
		</tr>
		<% for(Product product: products) {%>		
		<tr>
			<td><%=product.getId() %></td>
			<td><%=product.getName() %></td>
			<td><img src="Assets/Image/<%=product.getPhoto() %>" width="120" height="100"></td>
			<td><%=product.getPrice() %></td>
			<td><%=product.getQuantity() %></td>
			<td><%=product.isStatus()?"show":"hide"%></td>
			<td><%=S = product.getPrice() * product.getQuantity() + S %></td>			
		</tr>	
		<%} %>	
		<tr>
			<td colspan="6">Total Price</td>
			<td><%=S %>
		</tr>
	</table>
</body>
</html>