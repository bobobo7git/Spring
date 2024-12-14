<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>board list</h1>
	<table>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>write</th>
			<th>viewCnt</th>
			<th>regDate</th>
		</tr>
	<c:forEach items="${boards}" var="board">
		<tr>
			<td>${board.id}</td>
			<td>${board.title}</td>
			<td>${board.writer}</td>
			<td>${board.viewCnt}</td>
			<td>${board.regDate}</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>