<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Score Input Page</h1>
	<form action="/score" method="POST">
		name : <input type="text" name="name"><br>
		Korean : <input type="text" name="korean"><br>
		English : <input type="text" name="english"><br>
		Math : <input type="text" name="math">
		<button type="submit">submit</button>
	</form>
</body>
</html>