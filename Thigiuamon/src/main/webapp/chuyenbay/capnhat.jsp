<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Cap Nhat Chuyen Bay</h3>
	<form method="post" action="chuyenbay?macb=${ chuyenbay.macb }">
		<table>
			<tr>
				<td>Ten Chuyen bay</td>
				<td><input type="text" name="tencb" value="${ chuyenbay.tencb}"></td>
			</tr>
			<tr>
				<td>Ngay di</td>
				<td><input type="Date" name="ngaydi"
					value="${ chuyenbay.ngaydi }"></td>
			</tr>
			<tr>
				<td>Gia Ghe Loai 1</td>
				<td><input type="text" name="giaghe1"
					value="${ chuyenbay.giagheloai1 }"></td>
			</tr>
			<tr>
				<td>Gia Ghe Loai 2</td>
				<td><input type="text" name="giaghe2"
					value="${ chuyenbay.giagheloai2}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
</body>
</html>