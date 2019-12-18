<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<p>
<a href="${contextPath}/welcome">
			<button type="submit">Back</button>
		</a>
	</p>
	<div>
		<div>
			<h1>My Fav routes</h1>

			<table align="center" border="2">
				<tr>
					<th>Route Name</th>
					<th>Category of Travel</th>
					<th>Keywords</th>
					<th>Tell About Route</th>
					<th>Route from</th>
					<th>Route To</th>
					<th>Add by</th>
					<th>location</th>
					<th>placename</th>
					<th>placeinfoxxx</th>
				</tr>
				<c:forEach var="place" items="${places}">
					<tr>
						<td>${place.name}</td>
						<td>${place.type}</td>
						<td>${place.keywords}</td>
						<td>${place.decryption}</td>
						<td>${place.routefrom}</td>
						<td>${place.routeto}</td>
						<td>${place.username}</td>
						<td>${place.location}</td>
						<td>${place.placename}</td>
						<td>${place.placeinfo}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>