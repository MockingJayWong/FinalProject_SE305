<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Movie Detail</title>
</head>
<body>

<h3>Movie Detail</h3>
<table cellpadding="2" cellspacing="2" border="1">
	<tr>
		<td>Id</td>
		<td>${movie.id}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>${movie.movieName}</td>
	</tr>
	<tr>
		<td>Description</td>
		<td>${movie.introduction}</td>
	</tr>
	<tr>
		<td>Price</td>
		<td>${movie.score}</td>
	</tr>
</table>
<br/><br/>
<a href="/ticketjdbc/movie">Back</a>

</body>
</html>