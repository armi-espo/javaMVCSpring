<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Taglib</title>
</head>
<body>
	Pagina di test
	
	<table border="1">
		<tr>
			<th>Colonna</th>
		</tr>
	<c:forEach items="${list}" var="item">
		<tr>
			<td>
				<c:out value="${item}"/>
			</td>
		</tr>
	</c:forEach>	
	</table>
	
	
	<br>
	<c:if test="${numero <= 100}">
		Numero inferiore o uguale a 100
	</c:if>
	
	<br>
	Codice:<c:out value="${obj.codDoc}"></c:out>
	<br>
	Data formattata: <fmt:formatDate value="${obj.dataDoc}" pattern="dd/MM/yyyy"/>
</body>
</html>