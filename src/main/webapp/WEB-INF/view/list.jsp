<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Documenti</title>
<style type="text/css">
table {
	border: 1px solid gray;
	border-collapse: collapse;
}
th, td {
	border: 1px solid gray;
	border-collapse: collapse;
	padding: 3px;
}
</style>
</head>

<body>
	<table>
		<thead>
			<tr>
				<th>Codice</th>
				<th>Descrizione</th>
				<th>Data</th>
				<th>Tipo</th>
				<th>Numero pagine</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>
						<a href='<spring:url value="detail?docId=${item.id}"></spring:url>'>
							${item.codDoc}
						</a>
					</td>
					<td>${item.descDoc}</td>
					<td>
						<fmt:formatDate value="${item.dataDoc}" pattern="dd/MM/yyyy HH:mm:ss"/>
					</td>
					<td>${item.tipoDoc}</td>
					<td>${item.numPagine}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>