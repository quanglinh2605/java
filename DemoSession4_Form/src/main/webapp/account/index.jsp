<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"
	></script>
<script>
	tinymce.init({
		selector : 'textarea'
	});
</script>

</head>
<body>
	<h3>Register</h3>
	<form action="account?action=save" method="post">
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
				<td valign="top">Description</td>
				<td><textarea rows="5" cols="20" name="description"></textarea></td>
			</tr>
			<tr>
				<td valign="top">Gender</td>
				<td><input type="radio" name="gender" value="m"
					checked="checked"> Male <input type="radio" name="gender"
					value="f"> Female</td>
			</tr>
			<tr>
				<td valign="top">Status</td>
				<td><input type="checkbox" name="status"></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="languages" value="lang1">
					Language 1 <br> <input type="checkbox" name="languages"
					value="lang2"> Language 2 <br> <input type="checkbox"
					name="languages" value="lang3"> Language 3 <br> <input
					type="checkbox" name="languages" value="lang4"> Language 4
					<br> <input type="checkbox" name="languages" value="lang5">
					Language 5 <br></td>
			</tr>
			<tr>
				<td valign="top">Role</td>
				<td>
				<select name="role">
					<option value="r1">Role 1</option>
					<option value="r2">Role 2</option>
					<option value="r3">Role 3</option>
					<option value="r4">Role 4</option>
					<option value="r5">Role 5</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save"> 
				<br><input type="hidden" name="id" value = "123">
				 <a href="account?action=login">Login</a></td>
			</tr>
		</table>
	</form>
</body>
</html>