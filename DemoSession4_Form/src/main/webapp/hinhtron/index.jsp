<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<h3>Hinh tron</h3>
	<form action="hinhtron?action=save" method="post">
		<table>
			<tr>
				<td><input type="text" value="${r}" name="bankinh"><c:if test="${err != null}"><p style="color:red;">${err}</p></c:if></td>				
			</tr>			
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
	<c:if test="${r != null}">
		<p>Ban kinh: ${r}</p>
		<p>Dien tich: ${S}</p>
	</c:if>	