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

	<a href="${contextPath}/d">
		<button type="submit">Home</button>
	</a>

	<h1>Setup</h1>
	<form action="${contextPath}/addsetup">

		<select name="labname">
			<c:forEach var="l" items="${lablist}">
				<option>${l.labname}</option>
			</c:forEach>
		</select> <select name="testname">
			<c:forEach var="t" items="${testlist}">
				<option>${t.testname}</option>
			</c:forEach>
		</select> <br> <input type="submit">
	</form>
</body>
</html>