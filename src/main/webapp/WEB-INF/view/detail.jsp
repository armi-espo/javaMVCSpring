<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pt" uri="/WEB-INF/tlds/pagetemplate.tld"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<pt:page>

	<h4>Pagina di dettaglio del documento</h4>

	<form:form id="form2" action="delete" method="POST" modelAttribute="dto">
		<form:hidden path="id"/>
	</form:form>
	
	<sec:authorize access="hasRole('EDIT')" var="editEnabled"></sec:authorize>
	<c:if test="${editEnabled}">   	
		<div class="col-2">
			<button class="btn btn-primary" id="btnEdit">Modifica</button>
		</div>
	</c:if>
	
	<sec:authorize access="hasRole('DELETE')" var="deleteEnabled"></sec:authorize>
	<c:if test="${deleteEnabled}">   	
		<div class="col-2">
			<button class="btn btn-primary" id="btnDelete">Delete</button>
		</div>
	</c:if>
	
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
	
	<div id="posInListResult">
	
	</div>
	
	<script>
	$( document ).ready(function() {
		
		$("#btnEdit").click(function() {
			window.location.href='<spring:url value="update?docId=${dto.id}"/>';
		});
		
		$("#btnDelete").click(function() {
			$('#form2').submit();
		});
		
		$.get("posInList?id=${dto.id}", function( data ) {
			console.log(data);
			$('#posInListResult').html(data);
		});
	});
	
	</script>
</pt:page>