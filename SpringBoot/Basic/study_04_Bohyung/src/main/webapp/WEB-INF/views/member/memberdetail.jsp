<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Detail</h1>
	<h3>${member.name }</h3>
	<ul>
		<li>${member.id }</li>
		<li>${member.jumin }</li>
		<li>${member.age }</li>
		<li>${member.phone }</li>
		<li>${member.address }</li>
		<li>${member.profile_image }</li>
		
	</ul>
</body>
</html>