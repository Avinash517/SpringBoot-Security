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
	<form action="${contextPath}/${user}/add?${_csrf.parameterName}=${_csrf.token}"
		method="post" enctype="multipart/form-data">
          <div>
          Route Name:
			<input type="text" id="name" name="name" required/>
		</div>
		<div>
			<label>Category of Travel</label>
			<select name="type" id="type" required>
				<option value="nul">Select</option>
				<option value="Bus">Bus</option>
				<option value="Car">Car</option>
				<option value="Public Transport">Public Transport</option>
			</select>
		</div>
		<div>
			<label>Keywords</label>
			<input type="text" id="keywords" name="keywords" required />
		</div>
		<div>
			<label>Tell About Route</label>
			<input type="text" id="decryption" name="decryption" required/>
		</div>
		<div>
			<label>Route from</label>
			<input type="text" id="routefrom" name="rfrom" required/>
		</div>
		<div>
			<label>Route To</label>
			<input type="text" id="routeto" name="rto" required />
		</div>
		<div>
			<label>location</label>
			<input type="text" id="location" name="location" required/>
		</div>
		<div>
			<label>Place Name</label>
			<input type="text" id="placename" name="placename" required />
		</div>
		<div>
			<label>Tell About Place</label>
			<input type="text" id="placeinfo" name="placeinfo" required/>
		</div>
		<div>
			<label>Image</label>
			<input type="file" name="file" required/>
		</div>
		<div>
			<input type="submit" value="Add Route">
		</div>
	</form>
</body>
</html>