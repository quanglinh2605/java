<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	Hello World
	<br>
	<s:a namespace="/demo" action="demo2">Click Me</s:a>
	<br>
	<s:a namespace="/product" action="index">Product Info</s:a>
	<br>
	<s:url var="details1" namespace="/demo" action="demo3">
		<s:param name="id1">123</s:param>
	</s:url>
	<s:a href="%{details1}">Details 1</s:a>
	<br>
	<s:url var="details2" namespace="/demo" action="demo4">
		<s:param name="id1">456</s:param>
		<s:param name="id2">p01</s:param>
		<s:param name="id3">abc</s:param>
	</s:url>
	<s:a href="%{details2}">Details 2</s:a>
	<br>
	<s:a namespace="/demo" action="demo5">Demo Redirect</s:a>
	<br>
	<s:a namespace="/demo" action="demo6">Session</s:a>
	<br>
	<s:a namespace="/demo" action="demo7">Remove Session</s:a>
	
	
	
</body>
</html>