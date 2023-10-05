<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br /> 
		Trip date: <input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4"> Birder
		Name: <input type="text" name="birderName"><br /> 
		Available Sightings:<br /> <select name="allSightingsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allSightings}" var="currentsighting">
				<option value="${currentitem.id}">${currentitem.county}|
					${currentitem.species}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Sightings">
	</form>
	<a href="index.html">Go add new sighting instead.</a>
</body>
</html>