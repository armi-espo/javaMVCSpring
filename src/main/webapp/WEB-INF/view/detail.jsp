<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Dettaglio del documento</title>
	
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>
	<h4>Pagina di dettaglio del documento</h4>

	<div class="col-8">
		<div class="form-group">
			<label for="codDoc">Codice</label>
			<c:out value="${dto.codDoc}"></c:out>
		</div>
		<div class="form-group">
			<label for="descDoc">Descrizione</label>
			<c:out value="${dto.descDoc}"></c:out>
		</div>
		<div class="form-group">		
			<label for="dataDoc">Data</label>
			<fmt:formatDate value="${dto.dataDoc}" pattern="dd/MM/yyyy"/>
		</div>
		<div class="form-group">		
			<label for="tipoDoc">TipoDoc</label>
			<c:out value="${dto.tipoDoc}"></c:out>
		</div>
		<div class="form-group">		
			<label for="tipoDoc">Num Pagine</label>
			<c:out value="${dto.numPagine}"></c:out>
		</div>
		<div class="form-group">
			<label for="creationTime">Creation time</label>
			<c:out value="${dto.creationTime}"></c:out>
		</div>
	</div>
</body>
</html>