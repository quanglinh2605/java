<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Register</h3>
<form method="post" action="${ pageContext.request.contextPath }/account?action=register">
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username"></td>
		</tr>
		
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		
		<tr>
			<td>Fullname</td>
			<td><input type="text" name="fullname"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="save"></td>
		</tr>
	</table>
</form>
<a href="account?action=login">Login</a>
</body>
</html>