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
	<h1>Member List</h1>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>jumin</th>
			<th>age</th>
			<th>phone</th>
		</tr>
	<c:forEach items="${members}" var="member">
		<tr>
			<td>${member.id}</td>
			<td><a href="/member?id=${member.id}" >${member.name}</td>
			<td>${member.jumin}</td>
			<td>${member.age}</td>
			<td>${member.phone}</td>
			<td><form method="POST" action="/memberdelete?id=${member.id }" ><button>X</button></form></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>