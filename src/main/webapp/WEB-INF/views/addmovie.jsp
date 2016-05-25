<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="movie" action="addMovie" method="post">
		movieName：<form:input path="movieName" />
		<br/>
		url：<form:input path="url" />
		<br/>
		intro：<form:input path="introduction" />
		<br/>
		score：<form:input path="score" />
		<br/>
		start_time：<form:input path="start_time" />
		<br/>
		
		end_time：<form:input path="end_time" />
		<br/>
		<input type="submit" value="save" />
	</form:form>

</body>
</html>