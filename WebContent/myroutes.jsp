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
	<p>
		<a href="${contextPath}/welcome">
			<button type="submit">Back</button>
		</a>
	</p>
	<div>
		<div>

			<h1>My Routes</h1>

			<table align="center" border="2">
				<tr>
					<th>Id</th>
					<th>Route Name</th>
					<th>Category of Travel</th>
					<th>Keywords</th>
					<th>Tell About Route</th>
					<th>Route from</th>
					<th>Route To</th>
					<th>Add by</th>
					<th>location</th>
					<th>placename</th>
					<th>placeinfo</th>
					<th>For Edit</th>
					<th>For Delete</th>
					<th>Img</th>
					
				</tr>
				<c:forEach var="route" items="${routes}">
					<tr>
						<td>${route.id}</td>
						<td>${route.name}</td>
						<td>${route.type}</td>
						<td>${route.keywords}</td>
						<td>${route.decryption}</td>
						<td>${route.routefrom}</td>
						<td>${route.routeto}</td>
						<td>${route.username}</td>
						<td>${route.location}</td>
						<td>${route.placename}</td>
						<td>${route.placeinfo}</td>
						<td><a href="${contextPath}/${route.id}/">Edit</a></td>
						<td>
							<form action="${contextPath}/${route.id}/delete" method="get">
								<input type="submit" value="Delete" />
							</form>
						</td>
						<td>
						<%-- <img src="file:///${download}/${route.path}"/> --%>
						<embed src="${contextPath}/images/${route.path}" width="80" height="80">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>