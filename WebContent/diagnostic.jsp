<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${contextPath}/welcome">
		<button type="submit">Home</button>
	</a>
	<h1>Diagnostic</h1>

	<a href="${contextPath}/l">
		<button type="submit">Add Lab</button>
	</a>
	<br>
	<a href="${contextPath}/t">
		<button type="submit">Add test</button>
	</a>
	<br>
	<a href="${contextPath}/setup">
		<button type="submit">Setup lab</button>
	</a>
	<br>
	<a href="${contextPath}/searchlab">
		<button type="submit">Search lab</button>
	</a>
</body>
</html>