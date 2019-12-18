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
	<h1>Search Lab</h1>
	<form action="${contextPath}/resultserach">
		<select name="testname">
			<c:forEach var="t" items="${testlist}">
				<option>${t.testname}</option>
			</c:forEach>
		</select> <input type="submit" value="Search">
	</form>
	<h1>Result of labs</h1>
	<table>
		<tr>
			<th>Lab Name</th>
			<th>Location</th>
		</tr>
		<c:forEach var="r" items="${lablist}">
			<tr>
				<td>${r.labname}</td>
				<td>${r.location}</td>
				<td>
					<form action="${contextPath}/${r.labname}/${tname}/booking">
						<input type="submit" value="Book">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

   


</body>
</html>