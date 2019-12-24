<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="bootstrap/css/bootstrap.css">


<script src="bootstrap/js/jquery-3.4.1.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

<title>Excercice JSP-SERVLET</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Bases JEE</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  	<ul class="navbar-nav mr-auto">
		 <%--  	<c:forEach items="${menu }" var="m" varStatus="status">
		  	<li class="nav-item active">  
		  		<a class="nav-link" href="#"> <c:out value="${m }"></c:out> <span class="sr-only">(current)</span></a>  
		  	</li>
		 </c:forEach> --%>
 	        <li  class="nav-item active">  
		  		<a class="nav-link" href="controleur.php"> Gestion produits <span class="sr-only">(current)</span></a>  
		  	</li>
		  	<li  class="nav-item">  
		  		<a class="nav-link" href="controleur.js"> Mensualité crédit <span class="sr-only">(current)</span></a>  
		  	</li>
	</ul>
  </div>
</nav>


<div class="container">

	
	<h3>Calculer la mensualité d'un crédit bancaire</h3>
	 
	  <form method="post" action="controleur.do">
		  
		  <div class="form-group">
		    <label for="capital">Montant (DH)</label>
		    <input type="text" name="capital" class="form-control" value="${model.montant}" id="capital" placeholder="200000">
		  </div>
		  
		  <div class="form-group">
		    <label for="duree">Durée (Mois)</label>
		    <input type="number" name="duree" class="form-control" value="${model.duree}" id="duree" placeholder="240">
		  </div>
		  
		   <div class="form-group">
		    <label for="taux">taux (%)</label>
		    <input type="text" name="taux" class="form-control" value="${model.taux}" id="taux" placeholder="4.5">
		   </div>
		  
		   <input type="submit" value="Calculer" name="action" class="btn btn-primary">
 
	  </form>
	  <div class="row alert alert-success mt-5" role="alert">
	    <div class="col-md-10">
	    <h3>Le montant mensiel est: </h3>  
	     <c:if test="${ !empty model }">
		    
		    <fmt:formatNumber type = "number" groupingUsed = "false" value = "${model.mensialite}" />
	     </c:if>
	    </div>
	  </div>
	</div>
</body>
</html>