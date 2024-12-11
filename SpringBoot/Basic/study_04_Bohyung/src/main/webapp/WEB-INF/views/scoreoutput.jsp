<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	td {
		text-align:center;
	}
</style>
<body>
	<h1>Score Output Page</h1>
	<h3>${name }</h3>
	<table>
		<th></th>
		<th>Score</th>
		<th>Grade</th>
		<tr>
			<td>Korean</td>
			<td>${korScore }</td>
			<td>${korGrade }</td>
		</tr>
		<tr>
			<td>English</td>
			<td>${engScore }</td>
			<td>${engGrade }</td>
		</tr>
		<tr>
			<td>Math</td>
			<td>${mathScore }</td>
			<td>${mathGrade }</td>
		</tr>
	</table>
	<p>sum: ${sumScore}</p>
	<p>average: ${avgScore}</p>
</body>
</html>