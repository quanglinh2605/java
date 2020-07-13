<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Dat Ve</h3>
<form action="ve?macb=${ chuyenbay.macb }" method="post">
	<table>
		<tr>
			<td>Ho ten</td>
			<td><input type="text" name="hoten"></td>
		</tr>
		<tr>
			<td>Chung minh nhan dan</td>
			<td><input type="text" name="cmnd"></td>
		</tr>
		<tr>
			<td>Loai ghe</td>
			<td>
				<select name="loaighe">
					<option value="1">Loai 1</option>
					<option value="2">Loai 2</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Gia ghe</td>
			<td>
				<select name="giaghe">
					<option value="${ chuyenbay.giagheloai1 }">${ chuyenbay.giagheloai1 }</option>
					<option value="${ chuyenbay.giagheloai2 }">${ chuyenbay.giagheloai2 }</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="save"></td>
		</tr>
	</table>
</form>
</body>
</html>