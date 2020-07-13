<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="title">
	<span class="title_icon"> <img src="assets/user/images/bullet5.gif" alt=""
		title="" />
	</span>Categories
</div>

<ul class="list">
	<c:forEach var="category" items="${ categories }">
		<li><a href="${pageContext.request.contextPath }/home?action=category&category=${category.name}">${ category.name }</a></li>
	</c:forEach>
</ul>





