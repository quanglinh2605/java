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
	<s:form method="post" action="login_process" namespace="/account">
		<s:textfield label="Username" name="username"></s:textfield>
		<s:password label="Password" name="password"></s:password>
		<s:submit name="Login"></s:submit>
	</s:form>
</body>
</html>