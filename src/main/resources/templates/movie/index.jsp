<!--%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Movie List</title>
</head>
<body>

<h3>March 电影首页</h3>
<div>
	<div th:each="movie : ${movies}">
		<img src="/img/p1.png" />
		<h5 th:text="${movie.movieName}"></h5>
		<p th:text="${movie.introduction}"></p>
	</div>
</div>

<br/><br/>

<form action="#" th:action="@{/movie}" th:object="${movie}" method="post">
	<fieldset>
		<legend>Add New Movie</legend>

		<input type="text" th:field="*{movieName}"/>
		<input type="text" th:field="*{url}"/>
		<input type="text" th:field="*{introduction}"/>
		<input type="text" th:field="*{score}"/>

		<button type="submit">Add</button>
	</fieldset>
</form>

</body>
</html>
