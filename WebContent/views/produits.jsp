 <!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map.Entry"%>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des produis</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">

<script src="bootstrap/js/jquery-3.4.1.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

<script type="text/javascript">
	function confimeSupp(id){
		var conf = confirm("Do you want to delete this product ?");
		if(conf==true){
			document.location="controleur.php?action=supp&id="+id;
		}
	}
</script>
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
		  		<a class="nav-link" href="controleur.do"> Mensualité crédit <span class="sr-only">(current)</span></a>  
		  	</li>
	</ul>
  </div>
</nav>

<div class="jumbotron">
  <h1 class="display-4">Les Bases de l'architecture JEE- Servlet JSP, MVC, JSTL et Junit. !</h1>
  <p class="lead">Excercice pour maitriser les notions de bases de JEE.</p>
</div>


	<div class="container">
	<h3>Ajout des produis</h3>
	<p class="error">${exception }</p>
		<form method="post" action="controleur.php">
		
			  <div class="form-group">
		   		 <label for="identifiant">Identifiant: ${produit.id }</label>
		   		 <input type="hidden" name="id" class="form-control" value="${produit.id}" id="identifiant" placeholder="200000">
		  	  </div>
		  	  
		  	   <div class="form-group">
		   		 <label for="designation">Désignation</label>
		   		 <input type="text" name="designation" class="form-control" value="${produit.designation}" id="designation" placeholder="désignation">
		  	  </div>
		  	  
		  	   <div class="form-group">
		   		 <label for="prix">Prix</label>
		   		 <input type="text" name="prix" class="form-control" value="${produit.prix}" id="prix" placeholder="Prix">
		  	  </div>
		  	  
		  	   <div class="form-group">
		   		 <label for="qte">Quantité</label>
		   		 <input type="text" name="qte" class="form-control" value="${produit.qte}" id="qte" placeholder="Quantité">
		  	  </div>
		  
			
			<c:if test="${produit == null }">
			    <input type="submit" class="btn btn-success" value="Ajouter" name="action">
			</c:if>
			<c:if test="${produit != null }">
			    <input type="submit" class="btn btn-danger" value="Modifier" name="action">
			</c:if>
		
		</form>

<hr>

	<h3>Liste des produis</h3>
		<table class="table table-striped">
			<tr>
				<th>ID</th><th>Designation</th><th>Prix</th><th>Quantité</th><th colspan="2">Actions</th>
			</tr>
			<c:forEach items="${produits }" var="p">
				<tr>
				<td><a href="controleur.php?action=edit&id=${p.id }">${p.id }</a></td>
				<td><a href="controleur.php?action=edit&id=${p.id }">${p.designation }</a></td>
				<td>${p.prix }</td>
				<td>${p.qte }</td>
				<td><a class="btn btn-danger" href="javascript:confimeSupp('${p.id }')">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>