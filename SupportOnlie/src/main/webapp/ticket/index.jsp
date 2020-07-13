<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#priorityCombobox").on('change',function(){			
			var priority = $("#priorityCombobox option:selected").val();
			$.ajax({
				type :'get',
				url : 'ticket?action=search',
				dataType : 'json',
				contentType : 'application/json',
				data : {
					priority : priority
					},
				success : function(tickets){										
					var s = '';
					for(var i = 0 ; i < tickets.length ; i++){																		
						s += '<tr>';
						s+='<td>' + tickets[i].id + '</td>';
						s+='<td>' + tickets[i].title + '</td>';
						s+='<td>' + tickets[i].description + '</td>';
						s+='<td>' + tickets[i].priority + '</td>';
						s+='<td>' + tickets[i].status + '</td>';
						s+='<td>' + tickets[i].created +'</td>';
						s+='<td>' + '<a href="ticket?action=update&id=' + tickets[i].id + '">Update</a>'  +  '</td>';		
						s+='</tr>';
						}
					$('#ticketTable tbody').html(s); 
					} 	
				})
			});		
		});	
</script>
</head>
<body>
	<h3>List Ticket</h3>
	<select id="priorityCombobox">
		<option value="selectone">Select One</option>
		<option value="High" ${priority=="High"?"selected":""}>High</option>
		<option value="Urgent" ${priority=="Urgent"?"selected":""}>Urgent</option>
		<option value="Medium" ${priority=="Medium"?"selected":""}>Medium</option>
		<option value="Low" ${priority=="Low"?"selected":""}>Low</option>
	</select>
	<br>
	<br>
	<form method="post" action="ticket?action=finddate">
		<table>
			<tr>
				<td>Tu ngay</td>
				<td><input type="date" name="start" value="${start}"></td>
			</tr>
			<tr>
				<td>Den ngay</td>
				<td><input type="date" name="end" value="${end}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Find"></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<table border="1" id="ticketTable">
		<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
				<th>Priority</th>
				<th>Status</th>
				<th>Date created</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ticket" items="${tickets}">
				<tr>
					<td>${ticket.id}</td>
					<td>${ticket.title}</td>
					<td>${ticket.description}</td>
					<td>${ticket.priority}</td>
					<td>${ticket.status}</td>
					<td><fmt:formatDate var="date" value="${ticket.created}"
							pattern="dd/MM/yyyy" /> ${date}</td>
					<td><a href="ticket?action=update&id=${ticket.id}">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>	
	<a href="ticket?action=add">Add ticket</a>
</body>
</html>