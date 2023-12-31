<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Sightings</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allSightings}" var="currentsighting">
				<tr>
					<td><input type="radio" name="id"
						value="${currentsighting.id}"></td>
					<td>${currentsighting.county}</td>
					<td>${currentsighting.species}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToSighting"> <input
			type="submit" value="delete" name="doThisToSighting"> <input
			type="submit" value="add" name="doThisToSighting">
	</form>
</body>
</html>