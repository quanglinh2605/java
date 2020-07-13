<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="locale?action=demo1&langId=vi&countryId=VN">Vietnamese</a>
	<a href="locale?action=demo1&langId=ja&countryId=JP">Japan</a>
	<a href="locale?action=demo1&langId=fr&countryId=FR">France</a>
	<a href="locale?action=demo1&langId=en&countryId=US">UK</a>
	<br>Quantity: ${ quantity }
	<br>Percent: ${ percent }
	<br>Currency: ${ currency }
	<br>Date: ${ today }
	<br>Message: ${ msg }
	<br><a href="account">Back</a>
	<br><a href="locale?action=demo2">Another</a>
</body>
</html>