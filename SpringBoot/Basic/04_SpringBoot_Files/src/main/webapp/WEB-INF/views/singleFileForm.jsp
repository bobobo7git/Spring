<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Single File Form</h2>
	<form action="/singleFileUpload" method="POST" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<button>submit</button>
	
	</form>
</body>
</html>