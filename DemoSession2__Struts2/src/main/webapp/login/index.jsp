<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Login</h3>
${ errorMessage }
	<s:form method="post" namespace="/login" action="login">
		<s:textfield label="username" name="account.username"></s:textfield>
		<s:textfield label="password" name="account.password"></s:textfield>
		<s:submit name="Login"></s:submit>
	</s:form>
</body>
</html>