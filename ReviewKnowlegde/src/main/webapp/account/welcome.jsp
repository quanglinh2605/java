<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<h3>Welcome</h3>
Welcome ${sessionScope.username}
<a href="account?action=logout">Logout</a>
