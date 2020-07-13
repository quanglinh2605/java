<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${ sessionScope.locale == null ? 'en_US':sessionScope.locale }"/>
	<fmt:setBundle var="rs" basename="resource.content"></fmt:setBundle>
	
	<a href="locale?action=demo2&langId=vi&countryId=VN">Vietnamese</a>
	<a href="locale?action=demo2&langId=ja&countryId=JP">Japan</a>
	<a href="locale?action=demo2&langId=fr&countryId=FR">France</a>
	<a href="locale?action=demo2&langId=en&countryId=US">UK</a>
	<br>
	<fmt:formatNumber var="quantity" value="754546" type="number"></fmt:formatNumber>
	<fmt:message key="quantity" bundle="${ rs }"></fmt:message>: ${ quantity }
	<br>
	<fmt:formatNumber var="percent" value="0.51" type="percent"></fmt:formatNumber>
	<fmt:message key="percent" bundle="${ rs }"></fmt:message>: ${ percent }
	<br>
	<fmt:formatNumber var="price" value="45646" type="currency"></fmt:formatNumber>
	<fmt:message key="price" bundle="${ rs }"></fmt:message>: ${ price }
	<br>
	<fmt:formatDate var="today" value="<%=new Date() %>" dateStyle="full"/>
	<fmt:message key="today" bundle="${ rs }"></fmt:message>: ${ today }
	<br>
	<fmt:message key="msg" bundle="${ rs }"></fmt:message>
	
	<br><a href="account">Back</a>
</body>
</html>