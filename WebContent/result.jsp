
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="welcome">
	<button type="submit">Home</button>
</a>
			<div align="center">
			<h1>Explore interesting routes around the world</h1>
         		<form:form action="${contextPath}/search" method="post">
	         		<input type="text" name="routefrom" id=routefrom placeholder="Where from">
	         		<input type="text" name="routeto" id=routeto placeholder="Where to">
	         		<select name="type" id="type">
		                <option value="nul">Select</option>
		    			<option value="Bus">Bus</option>
		   				<option value="Car">Car</option>
		    			<option value="Public Transport">Public Transport</option>
	          		</select>
	         		<button> Search </button>
         		</form:form>
         	</div>
         	<br><br>
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
                            </tr>
                        </c:forEach>
                    </table>
                </div>
          </div>
</body>
</html>
