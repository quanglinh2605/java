<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Add Customer</h3>
	<form method="post" action="customer?action=edit&id=${ customer.id }">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" value="${ customer.name }" name="name"
					required="required"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" value="${ customer.address }"
					name="address" required="required"></td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td><input type="date" value="${ customer.birthday }"
					name="birthday" required="required"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" value="${ customer.phone }" name="phone"
					required="required"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
</body>
</html>