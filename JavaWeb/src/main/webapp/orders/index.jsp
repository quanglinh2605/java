<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".delete").on('click', function() {
			alert("kk");
			var id = this.id;
			$.ajax({
				url : "orders",
				type : "get",
				data : {
					id : id,
					action : 'delete'
				},
				success : function(data) {
					location.reload();
				}
			});
		});
	});
</script>
</head>
<body>
	<h3>Orders</h3>
	<table border="1">
		<tr>
			<th>Order ID</th>
			<th>Name</th>
			<th>Date Creation</th>
			<th>Status</th>
			<th>Payments</th>
			<th>Customer ID</th>
			<th>Options</th>
		</tr>
		<c:forEach var="item" items="${ orders }">
			<tr>
				<td>${ item.id }</td>
				<td>${ item.name }</td>
				<td>${ item.datecreation }</td>
				<td>${ item.status }</td>
				<td>${ item.payments }</td>
				<td>${ item.customer.id }</td>
				<td><a href="#" id="${ item.id }" class="delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>