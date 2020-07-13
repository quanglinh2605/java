<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Partners</h3>
<ul>
	<c:forEach var="partner" items="${partners }">
		<li>${partner }</li>
	</c:forEach>
</ul>