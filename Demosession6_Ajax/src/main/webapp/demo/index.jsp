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
		$("#buttonDemo1").on('click', function() {
			$.ajax({
				type : 'get',
				url : 'ajax1',
				success : function(result) {
					$('#result1').html(result)
				}
			})
		});
		$("#buttonDemo2").on('click', function() {
			$.ajax({
				type : 'get',
				url : 'ajax2',
				data : {
					id1 : "123",
					id2 : "p02"
				},
				success : function(result) {
					$('#result2').html(result)
				}
			})
		});
		$("#buttonResult").on('click', function() {
			$.ajax({
				type : 'post',
				url:'ajax3',
			})
		})
		$("#buttonDemo5").on('click', function() {
			$.ajax({
				type : 'GET',
				url : 'ajax3',
				dataType : 'json',
				contentType : 'application/json',
				success : function(product) {
					var s = "id: " + product.id;
					s += "<br> Name: " + product.name;
					s += "<br> Price: " + product.price;
					$("#result5").html(s);
				}
			})
		});
		$("#buttonDemo6").on('click', function() {
			$.ajax({
				type : 'GET',
				url : 'ajax4',
				dataType : 'json',
				contentType : 'application/json',
				success : function(products) {
					var s = '';
					for (var i = 0; i < products.length; i++) {
						s += '<tr>';
						s += '<td>' + products[i].id + '</td>'
						s += '<td>' + products[i].name + '</td>'
						s += '<td>' + products[i].price + '</td>'
						s += '</tr>';
					}
					$('#mytable tbody').html(s);
				}
			})
		});
		$('#textboxsearch').autocomplete({
			source : 'ajax5',
			select : function(event, ui) {
				window.location = 'product?Keyword=' + ui.item.value;
				//alert( "Selected: " + ui.item.value);
			}
		});

		$('#comboboxCategory').on('change', function() {
			var category = $('#comboboxCategory option:selected').val();			
			$.ajax({
				type : 'get',
				url : 'ajax6',
				dataType : 'json',
				contentType : 'application/json',
				data : {
					category : category
				},
				success : function(products) {
					var s = '';
					for (var i = 0; i < products.length; i++) {
						s += '<tr>';
						s += '<td>' + products[i].id + '</td>'
						s += '<td>' + products[i].name + '</td>'
						s += '<td>' + products[i].price + '</td>'
						s += '<td>' + products[i].category + '</td>'
						s += '<tr>';
					}
					$('#tableProducts tbody').html(s);
				}
			})
		});
		$('#comboboxCountries').on('change', function() {
			var countryId = $('#comboboxCountries option:selected').val();
			$.ajax({
				type : 'get',
				url : 'ajax7',
				dataType : 'json',
				contentType : 'application/json',
				data : {
					countryId : countryId
				},
				success : function(provinces) {
					var s = '';
					for (var i = 0; i < provinces.length; i++) {
						s += '<option value = "'+ provinces[i].id + '">' + provinces[i].name + '</option>'
					}
					$('#comboboxProvinces').html(s);
				}
			})
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>Demo 1</legend>
		<input type="button" value="Demo 1" id="buttonDemo1"> <br>
		<span id="result1"></span>
	</fieldset>
	<fieldset>
		<legend>Demo 2</legend>
		<input type="button" value="Demo 2" id="buttonDemo2"> <br>
		<span id="result2"></span>
	</fieldset>
	<fieldset>
		<legend>Check Username</legend>
		<input type="text" id=username /> <input type="button" value="check"
			id="buttonCheck"><br> <span id="result3"></span>
	</fieldset>
	<fieldset>
		<legend>Sum Number</legend>
		<input type="number" id="num1"> <br> <input type="number"
			id="num2"> <br> <input type="button" value="result"
			id="buttonResult"> <span id="result4"></span>
	</fieldset>
	<fieldset>
		<legend>Demo 5</legend>
		<input type="button" value="Demo 5" id="buttonDemo5"> <br>
		<span id="result5"></span>
	</fieldset>
	<fieldset>
		<legend>Demo 6</legend>
		<input type="button" value="Demo 6" id="buttonDemo6"> <br>
		<table id="mytable" border="1" style="border-collapse: collapse">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</fieldset>
	<fieldset>
		<legend>Demo 7</legend>
		<input type="text" id="textboxsearch">
	</fieldset>
	<fieldset>
		<legend>Demo 8</legend>
		<select id="comboboxCategory">
			<option value="selectone" selected>Select One</option>
			<option value="category 1">Category 1</option>
			<option value="category 2">Category 2</option>
			<option value="category 3">Category 3</option>
		</select>
		<table id="tableProducts" border="1">
			<thead>
				<tr>
					<th>Id</th>
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
	<fieldset>
		<legend>Demo 9 - Cascading DropDownList</legend>
		Country <select id="comboboxCountries">
			<option value="selectone">Select One</option>
			<c:forEach var="country" items="${ countries }">
				<option value="${ country.id }"> ${ country.name } </option>
			</c:forEach>
		</select><br>
		
		Provinces <select id="comboboxProvinces">
		<option value="selectone">Select One</option>
		
		</select><br>		
	</fieldset>
</body>
</html>