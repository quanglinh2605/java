<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="question">
		<ol>
			<c:forEach var="question" items="${ questions }">
				<li>${ question.content}<input type="hidden"
					value="${ question.id }" name="questionId">
					<ol type="a">
						<c:forEach var="answer" items="${ question.answer }">
							<li><input type="radio" name="question_${ question.id}"
								value="${ answer.id }"> ${ answer.content }</li>
						</c:forEach>
					</ol>
				</li>
			</c:forEach>
		</ol>
		<input type="submit" value="Submit">
	</form>
</body>
</html>