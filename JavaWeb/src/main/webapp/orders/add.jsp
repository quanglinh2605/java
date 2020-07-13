<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Add order</h3>
	<form method="post" action="orders?action=add">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Date Create</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><select name="status">
						<option value="true">Paid</option>
						<option value="false">Unpaid</option>
				</select></td>
			</tr>
			<tr>
				<td>Payments</td>
				<td><select name="payment">
						<option value="cash">Cash</option>
						<option value="visa card">Visa Card</option>
						<option value="master card">Master Card</option>
						<option value="paypal">Paypal</option>
				</select></td>
			<tr>
				<td>&nbsp; <input type="hidden" name="customerId"
					value="${ idCus}">
				</td>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
</body>
</html>