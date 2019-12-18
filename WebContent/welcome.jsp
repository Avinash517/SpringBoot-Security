<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create an account</title>
<%@ page isELIgnored="false"%>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2 align="center">${pageContext.request.userPrincipal.name}</h2>
			<h2 align="right">
				<a onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h2>
		</c:if>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<h2 align="center">Route Trip</h2>
	<p align="right">
		<a
			href="${contextPath}/${pageContext.request.userPrincipal.name}/new-route">
			<button type="submit">Add Route</button>
		</a>
	</p>
	<form
		action="${contextPath}/${pageContext.request.userPrincipal.name}/profile"
		method="GET">
		<input type="submit" value="My Profile" />
	</form>
	<form
		action="${contextPath}/${pageContext.request.userPrincipal.name}/myroute"
		method="GET">
		<input type="submit" value="My Routes" />
	</form>
	<form
		action="${contextPath}/${pageContext.request.userPrincipal.name}/myfavplace"
		method="GET">
		<input type="submit" value="My Fav Place" />
	</form>

	<a href="${contextPath}/m">
		<button type="submit">Maps</button>
	</a>

	<a href="${contextPath}/u">
		<button type="submit">Upload image</button>
	</a>
	<br>
	<a href="${contextPath}/d">
		<button type="submit">Diagnostic</button>
	</a>
	<br>
	<br>
	<div align="center">
		<h1>Explore interesting routes around the world</h1>
		<form:form action="${contextPath}/search" method="get">
			<input type="text" name="routefrom" id=routefrom
				placeholder="Where from">
			<input type="text" name="routeto" id=routeto placeholder="Where to">
			<select name="type" id="type">
				<option value="nul">Select</option>
				<option value="Bus">Bus</option>
				<option value="Car">Car</option>
				<option value="Public Transport">Public Transport</option>
			</select>
			<button>Search</button>
		</form:form>
	</div>
	<br>
</body>
</html>

