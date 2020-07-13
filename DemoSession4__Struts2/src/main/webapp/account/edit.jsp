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
	<s:form method="post" action="update" namespace="/account">
		<s:textfield name="account.username" label="Username" ></s:textfield>
		<s:password name="account.password" label="Password"></s:password>
		<s:textfield name="account.fullname" label="Full Name"></s:textfield>
		<s:checkbox name="account.status" label="Status"></s:checkbox>
		<s:submit name="Save"></s:submit>
		<s:hidden name="account.id"></s:hidden>
	</s:form>
</body>
</html>