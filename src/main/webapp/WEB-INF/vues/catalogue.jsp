<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Boutique GCR</title>

<c:set var="cxt" value="${pageContext.request.contextPath }" />

<spring:url value="bootstrap" var="bootstrap"></spring:url>
<spring:url value="images" var="images"></spring:url>
<link href="${cxt}/${bootstrap}/css/bootstrap.min.css" rel="stylesheet">



</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Boutique E-GCR</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="liste1">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="add">Ajouter</a></li>
        
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">${sessionScope.user.nom }</a></li>
         <li><a href="${cxt}/monpanier"> panier
        <span class="badge">${fn:length(sessionScope.panier)}</span>
         </a></li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
<div class="row">
<div class="col-md-3">
<div class="list-group">
	<c:forEach var="cat" items="${listec}">
	  <a href="${cxt}/liste3/${cat.id}" class="list-group-item "> ${cat.description}  </a>
	</c:forEach>

</div>


</div>

<div class="col-md-9">

<div class="panel panel-info">
<div class="panel-heading">Liste des Produits</div>
<div class="panel-body">

<div class="row">
<c:forEach var="p" items="${liste}">
	

  <div class="col-md-4">
    <div class="thumbnail">
      <img src="${cxt}/${images}/${p.id}.jpg" alt="...">
      <div class="caption">
        <h3>${p.description }</h3>        
        <p>
        <button class="btn btn-primary" >${p.prix } DT</button> 
        <a href="${cxt}/addpanier/${p.id}" class="btn btn-danger pull-right" >Panier</a>     
        
        </p>
      </div>
    </div>
  </div>

</c:forEach>
</div>
</div>

</div>


</div>

</div>
</div>


</body>
</html>