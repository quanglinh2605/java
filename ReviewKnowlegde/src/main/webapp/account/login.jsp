<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

	<h3>Login</h3>
	${ err }
	<form method="post" action="account?action=login">
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
				<td>&nbsp;</td>
				<td><input type="submit" name="Login" value="login"><br><a href="account?action=register">Register</a></td>
			</tr>
		</table>
	</form>
