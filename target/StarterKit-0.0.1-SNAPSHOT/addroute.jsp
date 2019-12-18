<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
	<h1>Add New Route</h1>
	<form:form action="${contextPath}/${user}/add" modelAttribute="route"
		method="post">
  user name: ${user}
          <div>
			<form:label path="name">Route Name</form:label>
			<form:input type="text" id="name" path="name" required="true" />
			<form:errors path="name" />
		</div>
		<div>
			<form:label path="type">Category of Travel</form:label>
			<select name="type" id="type" path="type" required="true">
				<option value="nul">Select</option>
				<option value="Bus">Bus</option>
				<option value="Car">Car</option>
				<option value="Public Transport">Public Transport</option>
			</select>
		</div>
		<div>
			<form:label path="keywords">Keywords</form:label>
			<form:input type="text" id="keywords" path="keywords" required="true" />
			<form:errors path="keywords" />
		</div>
		<div>
			<form:label path="decryption">Tell About Route</form:label>
			<form:input type="text" id="decryption" path="decryption"
				required="true" />
			<form:errors path="decryption" />
		</div>
		<div>
			<form:label path="routefrom">Route from</form:label>
			<form:input type="text" id="routefrom" path="routefrom"
				required="true" />
			<form:errors path="routefrom" />
		</div>
		<div>
			<form:label path="routeto">Route To</form:label>
			<form:input type="text" id="routeto" path="routeto" required="true" />
			<form:errors path="routeto" />
		</div>
		<div>
			<form:label path="location">location</form:label>
			<form:input type="text" id="location" path="location" required="true" />
			<form:errors path="location" />
		</div>
		<div>
			<form:label path="placename">Place Name</form:label>
			<form:input type="text" id="placename" path="placename"
				required="true" />
			<form:errors path="placename" />
		</div>
		<div>
			<form:label path="placeinfo">Tell About Place</form:label>
			<form:input type="text" id="placeinfo" path="placeinfo" required="true" />
			<form:errors path="placeinfo" />
		</div>
		<div>
			<input type="submit" value="Add Route">
		</div>
	</form:form>
</body>
</html>