<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Search</h3>
	<s:form method="post" namespace="/account" action="search">
		<s:textfield label="Keyword" name="keyword"></s:textfield>
		<s:submit value="Search"></s:submit>
	</s:form>
	
	<h3>Register</h3>
	<s:form method="post" namespace="/account" action="save">
		<s:textfield label="Username" name="account.username" cssClass="format"></s:textfield>
		<s:password label="Password" name="account.password"></s:password>
		<s:textarea label="Description" name="account.description" cols="20" rows="5"></s:textarea>
		<s:checkbox  name="account.status" label="Status"></s:checkbox>
		<s:checkboxlist label="Languages" list="languages" listKey="id" listValue="name" 
			name="account.languages"></s:checkboxlist>
		<s:radio label="Gender" list="#{'m':'Male', 'f':'Female' }" name="account.gender"></s:radio>
		<s:select label="Role" list="roles" listKey="id" listValue="name" name="account.role"></s:select>		
		<s:submit value="Save"></s:submit>
		<s:hidden name="account.id"></s:hidden>
	</s:form>
	<s:a namespace="/login" action="index">Login</s:a>
	
</body>
</html>