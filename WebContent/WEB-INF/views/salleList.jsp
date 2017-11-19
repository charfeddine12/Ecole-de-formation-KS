<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Liste des salles</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" style="height:60px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div style="position:absolute;top:-10px;">
          <a class="navbar-brand" href="<c:url value="/"/>"><img src="<c:url value="/resources/img/logo2.png"/>" style="height:60px;width:100px;"></a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right" style="">
            <li><a href="<c:url value="/j_spring_security_logout"/>" >Deconnexion</a></li>
          </ul>
          <form class="navbar-form navbar-right" style="margin-right:500px;">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="#"  data-toggle="collapse" data-target="#demo">Professeurs <span class="sr-only">(current)</span></a>
            <ul  id="demo" class="collapse">
            <li><a href="<c:url value="/professeurList"/>">Lister</a></li>
            <li><a href="<spring:url value="/professeurList/addProfesseur" />" >Ajouter</a></li>
            </ul>
            </li>
            <li><a href="#"  data-toggle="collapse" data-target="#demo1">Eleves</a>
            <ul  id="demo1" class="collapse">
            <li><a href="<c:url value="/eleveList"/>">Lister</a></li>
            <li><a href="<c:url value="/eleveList/addEleve"/>">Ajouter</a></li>
            </ul>
            </li>
            <li><a href="#"  data-toggle="collapse" data-target="#demo2">Specialites</a>
            <ul  id="demo2" class="collapse">
            <li><a href="<c:url value="/specialiteList"/>">Lister</a></li>
            <li><a href="<c:url value="/specialiteList/addSpecialite"/>">Ajouter</a></li>
            </ul>
            </li>
            <li><a href="#"  data-toggle="collapse" data-target="#demo3">Matieres</a>
            <ul  id="demo3" class="collapse">
            <li><a href="<c:url value="/matiereList"/>">Lister</a></li>
            <li><a href="<c:url value="/matiereList/addMatiere"/>">Ajouter</a></li>
            </ul>
            </li>
            <li><a href="#"  data-toggle="collapse" data-target="#demo4">Classes</a>
            <ul  id="demo4" class="collapse">
            <li><a href="<c:url value="/classeList"/>">Lister</a></li>
            <li><a href="<c:url value="/classeList/addClasse"/>">Ajouter</a></li>
            </ul>
            </li>
            <li><a href="#"  data-toggle="collapse" data-target="#demo5">Salles</a>
            <ul  id="demo5" class="collapse">
            <li><a href="<c:url value="/salleList"/>">Lister</a></li>
            <li><a href="<c:url value="/salleList/addSalle"/>">Ajouter</a></li>
            </ul>
            </li>
            <li><a href="#"  data-toggle="collapse" data-target="#demo6">Examens</a>
            <ul  id="demo6" class="collapse">
            <li><a href="<c:url value="/examenList"/>">Lister</a></li>
            <li><a href="<c:url value="/examenList/addExamen"/>">Ajouter</a></li>
            </ul>
            </li>
          </ul>
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         

          <div class="row placeholders">
            
          </div>

          <h2 class="sub-header">Liste des salles</h2>
          <div class="table-responsive">
            <table class="table table-striped table-hover" >
              <thead>
                <tr class="bg-success">
                  <th>Id</th>
                  <th>Nom</th>
                  <th>Forme</th>
                  <th></th>
                  
                </tr>
              </thead>
              <c:forEach items="${salles}" var="salle">
                <tr>
                  <td>${salle.idSalle}</td>
                  <td>${salle.nomSalle}</td>
                  <td>${salle.formeSalle}</td>
                  
                  <td>
                  
                  <a href="<spring:url value="/classeList/deleteSalle/${salle.idSalle}" />" >
                  <span class="glyphicon glyphicon-remove"></span></a>
                  <a href="<spring:url value="/classeList/editSalle/${salle.idSalle}" />" >
                  <span class="glyphicon glyphicon-pencil"></span></a>
                  </td>
                </tr>
                </c:forEach>
            </table>
            
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script>window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"><\/script>')</script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  </body>
</html>