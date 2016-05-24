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
        <a th:href="'/movie/'+${movie.id}"><img src="/img/p1.png" /></a>
        <h5 th:text="${movie.movieName}"></h5>
        <p th:text="${movie.introduction}"></p>
    </div>
    <div>
        <a th:href="'/movie/' + ${movie.id} + 'content'">购票</a>
    </div>
</div>

<br/><br/>

</body>
</html>
