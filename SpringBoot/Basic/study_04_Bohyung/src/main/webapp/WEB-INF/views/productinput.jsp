<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Input</h1>
	<form action="/product" method="POST" enctype="multipart/form-data">
		product : <input type="text" name="product"><br>
		price : <input type="text" name="price"><br>
		category : 
		<select name="category">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>	
		</select><br>
		image<br>
		<input type="file" name="file"><br>
		<hr>
		<button>submit</button>
		
		
	</form>
</body>
</html>