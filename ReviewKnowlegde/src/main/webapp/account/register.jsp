<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<h3>Register</h3>
<form method="post" action="account?action=save">
	<table>
		<tr>
			<td>Usename</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td valign="top">Description</td>
			<td><textarea rows="5" cols="20" name="description" style="resize: none;"></textarea>
		</tr>
		<tr>
			<td valign="top">Gender</td>
			<td><input type="radio" name="gender" value="female" checked>Female<input
				type="radio" name="gender" value="male">Male</td>
		</tr>
		<tr>
			<td valign="top">Status</td>
			<td><input type="checkbox" name="status"></td>
		</tr>
		<tr>
			<td valign="top">Languages</td>
			<td>
				<input type="checkbox" name="languages" value="lang 1"> Language 1<br>
				<input type="checkbox" name="languages" value="lang 2"> Language 2<br>
				<input type="checkbox" name="languages" value="lang 3"> Language 3<br>
				<input type="checkbox" name="languages" value="lang 4"> Language 4<br>
				<input type="checkbox" name="languages" value="lang 5"> Language 5<br>
			</td>
		</tr>		
		<tr>
			<td>Role</td>
			<td><select name="role">
				<option value="role1" selected>Role 1</option>
				<option value="role2">Role 2</option>
				<option value="role3">Role 3</option>
				<option value="role4">Role 4</option>
				<option value="role5">Role 5</option>
			</select></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Save"><input type ="hidden" name="id" value="123">
			<br><a href="account?action=login">Login</a>
			</td>
		</tr>
	</table>
</form>
