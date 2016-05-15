<!-- %@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%   PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Movie Detail</title>
</head>
<body>

<h3>Movie Detail</h3>
<table cellpadding="2" cellspacing="2" border="1">
	<tr>
		<td>Id</td>
		<td th:text="${movie.id}"></td>
	</tr>
	<tr>
		<td>Name</td>
		<td th:text="${movie.name}"></td>
	</tr>
	<tr>
		<td>Description</td>
		<td th:text="${movie.description}"></td>
	</tr>
	<tr>
		<td>Price</td>
		<td th:text="${movie.price}"></td>
	</tr>
</table>
<br/><br/>
<a th:href="@{/movie}">Back</a>

</body>
</html>