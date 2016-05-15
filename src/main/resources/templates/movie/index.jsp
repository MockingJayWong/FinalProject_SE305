<!--%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Movie List</title>
</head>
<body>

<h3>Movie List</h3>
<table cellpadding="2" cellspacing="2" border="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Description</th>
		<th>Price</th>
	</tr>
	<tr th:each="movie : ${movies}">
		<td th:text="${movie.id}"></td>
		<td th:text="${movie.name}"></td>
		<td th:text="${movie.description}"></td>
		<td th:text="${movie.price}"></td>
		<td>
			<a th:href="@{'/movie/detail/' + ${movie.id}}">Detail</a>
		</td>
	</tr>
</table>

<br/><br/>

<form action="#" th:action="@{/movie}" th:object="${movie}" method="post">
	<fieldset>
		<legend>Add New Movie</legend>
		
		<input type="text" th:field="*{name}"/>
		<input type="text" th:field="*{description}"/>
		<input type="text" th:field="*{price}"/>
		
		<button type="submit">Add</button>
	</fieldset>
</form>

</body>
</html>