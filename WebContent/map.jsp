<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
#map {
	height: 400px;
	width: 100%;
}
</style>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCwMX-37iZeDFy6S8Lk8Y0Nfu5b6fhlFc8&libraries=places"
	type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var map = new google.maps.Map(document.getElementById('map'), {

			center : {
				lat : 17.3850,
				lng : 78.4867
			},
			zoom : 12
		});
		var marker = new google.maps.Marker({
			position : {
				lat : 17.3850,
				lng : 78.4867
			},
			map : map,
			draggable : true
		});
		$('#change').click(function() {
			var area;
			var to=$('#routeto').val();
			var type=$('#type').val();
			var input = $('#area').val();
			switch (input) {
			case "India":
				area = {
					lat : 20.5937,
					lng : 78.9629
				};
				break;
			case "bengaluru":
				area = {
					lat : 12.9716,
					lng : 77.5946
				};
				break;
			case "chennai":
				area = {
					lat : 13.0827,
					lng : 80.2707
				};
				break;
			case "hyderabad":
				area = {
					lat : 17.3850,
					lng : 78.4867
				}
			}
			var map = new google.maps.Map(document.getElementById('map'), {
				center : area,
				zoom : 12
			});
			var marker = new google.maps.Marker({
				position : area,
				map : map,
				draggable : true
			});
			var html="";
			$.ajax({
				type: 'GET',
				url: "/StarterKit/searchinmap",
				data:{from:input,to:to,type:type},
				success: function(data){
					$.each(data,function(index,value){
						html+="<tr><td>"+value.id+"</td><td>"+value.name+"</td><td>"+value.routefrom+
						"</td><td>"+value.routeto+
						"</td><td><a href='/StarterKit/"+value.name+"/searchbyroutename'>click</a></tr>"
					});
					$("#tbody").html(html);
				}
				
			});

		});
	});
</script>
</head>
<body>
	<h3>My Google Maps Demo</h3>
	<div id="map"></div>
	
		<button id="change">change</button>
		<select id="area" name="area">
			<option value="hyderabad">Hyderabad</option>
			<option value="bengaluru">Bengaluru</option>
			<option value=chennai>Chennai</option>
		</select>
		<input type="text" name="routeto" id="routeto" placeholder="Where to">
		<select name="type" id="type">
			<option value="nul">Select</option>
			<option value="Bus">Bus</option>
			<option value="Car">Car</option>
			<option value="Public Transport">Public Transport</option>
		</select>

	<h1>Result</h1>
	<br>
	<div>

		<h1 align="center">Search Result</h1>
		<table align="center" border="2">
			<tr>
				<th>Id</th>
				<th>Route Name</th>
				<th>Route from</th>
				<th>Route To</th>
				<th>Action</th>
			</tr>
			<tbody id="tbody">
			</tbody>
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



</body>
</html>
