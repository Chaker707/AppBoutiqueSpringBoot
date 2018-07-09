<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Boutique GCR</title>
<spring:url value="bootstrap" var="bootstrap"></spring:url>
<spring:url value="images" var="images"></spring:url>
<link href="${bootstrap}/css/bootstrap.min.css" rel="stylesheet">



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
        <li class="active"><a href="liste">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
<div class="row">
<div class="col-md-3">
<div class="list-group">
  <a href="#" class="list-group-item active">PC Portable  </a>
  <a href="#" class="list-group-item">PC</a>
  <a href="#" class="list-group-item">Phone</a>
  <a href="#" class="list-group-item">Acc</a>

</div>


</div>

<div class="col-md-9">

<div class="panel panel-info">
<div class="panel-heading">Ajouter un produit</div>
<div class="panel-body">

<form:form action="save" method="post" modelAttribute="p">
	<form:input type="text" path="id" />
	<form:input type="text" path="description" />
	<form:input type="text" path="prix" />
	<form:input type="text" path="qte" />
	
	<input type="submit" value="Enregistrer">
</form:form>




</div>

</div>


</div>

</div>
</div>


</body>
</html>