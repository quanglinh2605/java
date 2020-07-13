<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".delete").on('click', function() {	
			var id = this.id;
			$.ajax({
			url: "ve",
			type: "get",
			data: {
			mave : id,
			action : 'delete'
			},
			success : function(data){
			location.reload();
			}
		});
		});
	});
</script>
</head>
<body>
	<h3>Danh sach ve</h3>
	<table border="1" id="listve">
		<thead>
			<tr>
				<th>Ma ve</th>
				<th>Ten hanh khach</th>
				<th>CMND</th>
				<th>Loai Ghe</th>
				<th>Gia Ghe</th>
				<th>Ma Chuyen Bay</th>
				<th>Tuy Chon</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ ves }">
				<tr align="center">
					<td>${item.mave}</td>
					<td>${ item.hotenhanhkhach }</td>
					<td>${ item.cmnd }</td>
					<td>${ item.loaighe }</td>
					<td>${ item.giaghe }</td>
					<td>${ item.chuyenbay.macb }</td>
					<td><button id="${item.mave }" class="delete">Delete</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>