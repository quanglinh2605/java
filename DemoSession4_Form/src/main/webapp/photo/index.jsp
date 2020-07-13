<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<img src="assets/images/2019-11-11.png" width="${width}"
		height="${height}">
	<br>
	<br>
	<form method="post" action="photo">
		<input type="radio" name="size" value="120x100" ${size=="120x100"?"checked":""}> 120x100
		<input type="radio" name="size" value="300x200" ${size=="300x200"?"checked":""}>300x200
		<input type="radio" name="size" value="500x300" ${size=="500x300"?"checked":""}>500x300 <br>
		<input type="submit" value="Apply">
	</form>
</body>
</html>