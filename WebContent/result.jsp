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
<style>
#map {
        height: 400px;
        width: 100%;
       }
</style>


<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDCC4UktmznnXlQpaiTx6HSLkuvdq9255E&libraries=places" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
var map = new google.maps.Map(document.getElementById('map'), {

center:{ lat: 17.3850,lng:78.4867},
		zoom: 12
});
 var marker = new google.maps.Marker({
position:{lat: 17.3850,lng:78.4867}, map: map,draggable:true
});
$('#change').click(function(){
	var area;
	var input=$('#area').val();
	switch (input) {
  	case "India":
    		area={lat:20.5937,lng:78.9629};
    		break;
  	case "bengaluru":
			area={lat:12.9716,lng:77.5946};
    		break;
	case "chennai":
			area={lat:13.0827,lng:80.2707};
    		break;
    case "hyderabad":
    		area={lat:17.3850,lng:78.4867}
	}
	var map = new google.maps.Map(document.getElementById('map'), {
	center:area,
		zoom: 12
	});
	var marker = new google.maps.Marker({
	position:area, map: map,draggable:true
	});

});
});
</script>
</head>
<body>
	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2 align="center">Welcome
				${pageContext.request.userPrincipal.name}</h2>
			<h2 align="right">
				<a onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h2>
		</c:if>
	</div>

	<a href="welcome">
		<button type="submit">Home</button>
	</a>
	<div align="center">
		<h1>Explore interesting routes around the world</h1>
		<form action="${contextPath}/search" method="get">
			<input type="text" name="routefrom" id=routefrom
				placeholder="Where from"> 
				<input type="text" name="routeto"
				id=routeto placeholder="Where to"> 
				<select name="type"
				id="type">
				<option value="nul">Select</option>
				<option value="Bus">Bus</option>
				<option value="Car">Car</option>
				<option value="Public Transport">Public Transport</option>
			</select>
			<button>Search</button>
		</form>
	</div>

<h3>My Google Maps Demo</h3>
    <div id="map"></div>
    <form action="${contextPath}/searchbyrfrom">
   <button type="submit" id="change"> change</button>
	<input type="text" id="area" name="area"/>
</form>

	<br>
	<br>
	<div>
		<div>

			<h1 align="center">Search Result</h1>
			<table align="center" border="2">
				<tr>
					<th>Id</th>
					<th>Route Name</th>
					<th>Category of Travel</th>
					<th>Keywords</th>
					<th>Tell About Route</th>
					<th>Route from</th>
					<th>Route To</th>
					<th>Added by</th>
					<th>location</th>
					<th>placename</th>
					<th>placeinfo</th>
					<th>Action</th>
				</tr>
				<c:forEach var="route" items="${route}">
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
						<td>
							<form
								action="${contextPath}/${route.id}/${pageContext.request.userPrincipal.name}/favp"
								method="get">
								<input type="submit" value="Add To Fav Place" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
