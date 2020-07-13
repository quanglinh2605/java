<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt2" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="mt" uri="http://abc.com/mytags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Custom tag</h3>
	<mt2:hello></mt2:hello>
	<mt2:Hi fullName="Dog"></mt2:Hi>
	<br>
	<mt2:Sum b="5" a="7"></mt2:Sum>
	<br>


	<mt2:display>
		<jsp:attribute name="content">
			<b><u><i>Display tag</i></u></b>
	</jsp:attribute>
	</mt2:display>

	<br>


	<mt:Hello />
	<br>
	<mt:Hello />
	<br>
	<mt:Hi />
	<br>
	<mt:Hi />
	<br>
	<mt:Sum b="4" a="5" />
	<br> 5+20=
	<mt:Sum b="5" a="20" />
	<br>
	<mt:Caculate b="24" sign="/" a="12" />
	<br> 12*12=
	<mt:Caculate b="12" sign="x" a="12" />
	<br>
	<mt:Caculate b="40" sign="-" a="120" />
</body>
</html>