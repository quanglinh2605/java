<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
	})
</script>
</head>
<body>
	<fieldset>
		<legend>Demo 2</legend>
		<input type="button" value="Demo 2" id="buttonDemo2"> <br>
		<span id="result2"></span>
	</fieldset>
	<fieldset>
<legend>Check Username</legend>
<input type ="text" id = usename/>
	</fieldset>
</body>
</html>