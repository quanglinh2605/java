<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Hinh vuong</h3>
<form action="hinhvuong?action=save" method="post">
	<table>
		<tr>
			<td><input type="text" value="${a}" name="canh"> <c:if
					test="${err != null}">
					<p style="color: red;">${err}</p>
				</c:if></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</table>
</form>
<c:if test="${a != null }">
	Canh vua nhap la: ${ a}<br>
	Dien tich hinh vuong la: ${S }<br>
</c:if>
