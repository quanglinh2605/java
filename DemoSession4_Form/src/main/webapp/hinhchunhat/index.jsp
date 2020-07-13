<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Hinh chu nhat</h3>
<form action="hinhchunhat?action=save" method="post">
	<table>
		<tr>
			<td><input type="text" value="${cd}" name="chieudai"> <c:if
					test="${err !=null}">
					<p style="color: red;">${ err }</p>
				</c:if></td>
		</tr>
		<tr>
			<td><input type="text" value="${cr}" name="chieurong"></td>
			<c:if test="${err !=null}">
				<p style="color: red;">${ err }</p>
			</c:if>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</table>
</form>
<c:if test="${cd!=null && cr!=null}">
	Chieu Dai: ${cd}<br>
	Chieu Rong: ${cr}<br>
	Dien tich: ${S}<br>
</c:if>
