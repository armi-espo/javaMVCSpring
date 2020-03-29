<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sec:authorize access="hasRole('ROLE_EDIT')" var="editEnabled"></sec:authorize>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principale</title>
</head>
<body>

	Menu
	<c:if test="${editEnabled}">
		<br>	
		<a href="insert">Inserisci documento</a>
	</c:if>
	<br>
	<a href="list">Lista documenti</a>
	<br>
</body>
</html>