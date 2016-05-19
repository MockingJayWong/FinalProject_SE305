<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Movie List</title>
</head>
<body>

	<h3>Movie List</h3>
	<img alt="a" src="/ticketjdbc/resources/images/bd_logo1.png" />
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
		</tr>

		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.id}</td>
				<td>${movie.movieName}</td>
				<td>${movie.introduction}</td>
				<td>${movie.score}</td>
				<td><a href="/ticketjdbc/movie/detail/${movie.id}">Detail</a></td>
				<td><a href="/ticketjdbc/movie/delete/${movie.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<br />

	<form:form action="/ticketjdbc/movie" method="post" commandName="movie">
		<fieldset>
			<legend>Add New Movie</legend>

			<form:input type="text" path="movieName" />
			<form:input type="text" path="url" />
			<form:input type="text" path="introduction" />
			<form:input type="text" path="score" />

			<button type="submit">Add</button>
		</fieldset>
	</form:form>

</body>
</html>