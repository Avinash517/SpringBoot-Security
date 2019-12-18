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
	<form:form action="${contextPath}/${rid}/ipadd" modelAttribute="place"
		method="post">
  Route id: ${rid}
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
			<form:label path="decryption">Tell About Place</form:label>
			<form:input type="text" id="decryption" path="decryption" required="true" />
			<form:errors path="decryption" />
		</div>
		<div>
			<input type="submit" value="Add Place">
		</div>
  </form:form>
</body>
</html>