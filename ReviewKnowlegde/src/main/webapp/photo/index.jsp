<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Photo</h3>
<img src="assets/images/image1.jpg" width="${ height }" height="${ width }">
<form method="post" action="photo">
	<br><br>
	<input type="radio" name="size" value="120x100" ${ size == "120x100"?"checked":""}>120x100
	<input type="radio" name="size" value="300x200" ${ size == "300x200"?"checked":""}>300x200
	<input type="radio" name="size" value="500x350" ${ size == "500x350"?"checked":""}>500x350
	<br><input type="submit" value="apply">
</form>
</body>
</html>