<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Simple Sidebar - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="<spring:url value='/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<spring:url value='/css/simple-sidebar.css'/>" rel="stylesheet">

  <!-- Bootstrap core JavaScript -->
  <script src="<spring:url value='/vendor/jquery/jquery.min.js'/>"></script>
  <script src="<spring:url value='/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

</head>

<body>

  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">Gestione Doc </div>
      <div class="list-group list-group-flush">
      
		<sec:authorize access="hasRole('EDIT')" var="editEnabled"></sec:authorize>      
      	<c:if test="${editEnabled}">
	        <a href="insert" class="list-group-item list-group-item-action bg-light">Inserisci Documento</a>
		</c:if>
        <a href="list" class="list-group-item list-group-item-action bg-light">Lista Documenti</a>

      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Lingua
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="javascript:changeLanguage('IT')">IT</a>
                <a class="dropdown-item" href="javascript:changeLanguage('EN')">EN</a>
              </div>
            </li>
            <li class="nav-item active">
              <spring:url value="/logout" var="logoutUrl"/>
              <form:form id="form1" method="POST" action="${logoutUrl}">
              	<a class="nav-link" href="#" onclick="logout()">Esci</a>
              </form:form>
            </li>
          </ul>
        </div>
      </nav>

      <div class="container-fluid">
      
		<jsp:doBody/>
      
      </div>
    </div>
    <!-- /#page-content-wrapper -->

  </div>
  <!-- /#wrapper -->
	<script>
		function logout() {
			$("#form1").submit();
		}
		
		function changeLanguage(lingua) {
			
			var separator = "?";
			if (window.location.href.indexOf('?') > 1) {
				separator = "&";
			}
			window.location.href=window.location.href + separator + 'lingua=' + lingua;
		}
	</script>
</body>

</html>
