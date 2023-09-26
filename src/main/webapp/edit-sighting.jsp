<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Sighting</title>
</head>
<body>
	<form action="editSightingServlet" method="post">
		County: <input type="text" name="county" value="${sightingToEdit.county}">
		Species: <input type="text" name="species" value="${sightingToEdit.species}">
		<input type="hidden" name="id" value="${sightingToEdit.id}"> <input
			type="submit" value="Save Edited Sighting">
	</form>
</body>
</html>