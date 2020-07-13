<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ attribute name="title" required="true" rtexprvalue="true"
	type="java.lang.String"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib prefix="mt" uri="http://abc.com/mytags"%>
<html>
<head>
<title>${title }</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/home">Home| </a>
	<a href="${pageContext.request.contextPath }/about">About Us| </a>
	<a href="${pageContext.request.contextPath }/news"> News</a>
	<br>
	<br>
	<table border="1">
		<tr>
			<td valign="top" width="200"><mt:categories /> <mt:partners /> <mt:promotion />
			</td>
			<td valign="top" width="600"><jsp:invoke fragment="content"></jsp:invoke>
			</td>
		</tr>

	</table>


	<br>
	<br> CopyRight
</body>
</html>