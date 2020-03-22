<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Creazione nuovo documento</title>
	
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<style type="text/css">
	.error {
		border: 1px solid red;
	}
	</style>
</head>
<body>

	<h4><spring:message code="page.title.insert" ></spring:message> </h4>
	
	<div class="col-8">
		<form:form method="POST" modelAttribute="dto">
	
			<div class="form-group">
				<label for="codDoc">Codice</label>
				<form:input type="text" path="codDoc" cssClass="form-control"></form:input>
			</div>
			<div class="form-group">
				<label for="descDoc">Descrizione</label>
				<form:input type="text" path="descDoc" cssClass="form-control"></form:input>
			</div>
			<div class="form-group">
				<label for="dataDoc">Data</label>
				<spring:bind path="dataDoc">
					<form:errors path="dataDoc" cssStyle="font-weight:bolder;color:red"/>
					<form:input type="text" path="dataDoc"
						cssClass="form-control ${status.error ? 'error' : ''}"></form:input>
				</spring:bind>
			</div>
			<div class="form-group">
				<label for="tipoDoc">TipoDoc</label>
				<form:input type="text" path="tipoDoc" cssClass="form-control"></form:input>
			</div>
			<div class="form-group">		
				<label for="numPagine">Num Pagine</label>
				<spring:bind path="numPagine">
					<form:errors path="numPagine" cssStyle="font-weight:bolder;color:red"/>
					<form:input type="text" path="numPagine" cssClass="form-control"></form:input>
				</spring:bind>
			</div>
			<div class="form-group">		
				<label for="creationTime">Creation Time</label>
				<spring:bind path="creationTime">
					<form:errors path="creationTime" cssStyle="font-weight:bolder;color:red"/>
					<form:input type="text" path="creationTime" cssClass="form-control"></form:input>
				</spring:bind>
			</div>
			<button class="btn btn-success">Conferma dati</button>
		</form:form>
	</div>
</body>
</html>