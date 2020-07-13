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
	<h3>Register</h3>
	<s:form method="post" namespace="/account" action="save">
		<s:textfield label="Username" name="account.username"></s:textfield>
		<s:password label="Password" name="account.password"></s:password>
		<s:textfield label="Email" name="account.email"></s:textfield>
		<s:submit name="Save"></s:submit>
	</s:form>
</body>
</html>