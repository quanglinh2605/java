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
	$(document).ready(function() {
			
		$("#btnDemo1").on('click',function(){					
			$.ajax({
				type : 'get',
				url : 'ajax?action=products',
				dataType : 'json',
				contentType : 'application/json',
				success: function(products){
					var s = '';
					for (var i = 0; i < products.length; i++) {
						s += '<tr>';
						s += '<td>' + products[i].id + '</td>'
						s += '<td>' + products[i].name + '</td>'
						s += '<td>' + products[i].price + '</td>'
						s += '<td>' + products[i].category + '</td>'
						s += '<tr>';
					}
					$('#productTable tbody').html(s);
				}
				})
			});
		$("#productcombobox").on('change',function(){
			var category = $("#productcombobox option:selected").val();
			$.ajax({
					type : 'get',
					url : 'ajax?action=filter',
					dataType : 'json',
					contentType : 'application/json',
					data:{
						category : category
						},
					success : function(products){
						var s = '';
						for (var i = 0; i < products.length; i++) {
							s += '<tr>';
							s += '<td>' + products[i].id + '</td>'
							s += '<td>' + products[i].name + '</td>'
							s += '<td>' + products[i].price + '</td>'
							s += '<td>' + products[i].category + '</td>'
							s += '<tr>';
						}
						$('#productTable tbody').html(s);
						}
				})
			});
		$('#textboxSearch').autocomplete({
			source:'ajax?action=autocomplete',
			select: function(event,ui){
				window.location = 'ajax?action=search&keyword=' + ui.item.value;
				}
			});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>Demo 1</legend>
		<input type="button" id="btnDemo1" value="Apply"> <select
			id="productcombobox">
			<option id="selectone" selected>Select One</option>
			<option value="category 1">category 1</option>
			<option value="category 2">category 2</option>
			<option value="category 3">category 3</option>
		</select>
		<input type="text" id="textboxSearch">
		<table id="productTable" border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "product" items="${ products }">
				<tr>
					<td>${ product.id }</td>
					<td>${ product.name }</td>
					<td>${ product.price }</td>					
					<td>${ product.category }</td>					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
</body>
</html>