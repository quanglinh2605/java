<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:a namespace="/home" action="index">Home</s:a>
	<s:a namespace="/aboutus" action="index">AboutUs</s:a>
	<s:a namespace="/news" action="index">News</s:a>
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
	Copyright
</body>
</html>