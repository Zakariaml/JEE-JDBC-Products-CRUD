<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
</head>
<body>
<!-- Navigation Bar HERE -->

<%@ include file="header.html" %>
<br><br><br>
<c:choose>
	<c:when test="${key != null }">
	<h2> Résultat de recherche pour le mot clé ${key}</h2>
	</c:when>
	<c:otherwise>
	<h2>Listes des produits</h2>
	
	</c:otherwise>
</c:choose>
<br>
	<div class="row">
		<div class="col">
			
		</div>
		<div class="col">
			<a href="controlleur.php?action=add" class="btn btn-primary btn-lg btn-block">Ajouter un produit</a>
		<br>
		<c:choose>
			<c:when test="${ModifiedOrAdded =='Modified' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					Le produit bien modifié!
				</div>
			</c:when>
			<c:when test="${ModifiedOrAdded =='Added' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					Le produit bien ajouté!
				</div>
			</c:when>
		</c:choose>
		
		
		</div>
		<div class="col">
			
		</div>
	</div>
	<br>
<div class="container">
	<table class="table table-striped" >
		<thead>
		<tr>
			<th> Réference </th>
			<th> Désignation </th>
			<th> Prix </th>
			<th> Quantité </th>
			<th> Réference dépot </th>
			<th> Action </th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listprod}" var="p">
		<tr>	
			<td> ${p.reference } </td>
			<td> ${p.designation } </td>
			<td> ${p.prix } </td>
			<td> ${p.quantite } </td>
			<td> ${p.warehouse_ref } </td>
			<td> <a href="controlleur.php?action=modify&ref=${p.reference}"> Modifier</a> | 
			<a href="controlleur.php?action=delete&ref=${p.reference }" 
			onclick="if (!(confirm('Are you sure you want to delete this product ?'))) return false">Supprimer</a>
			  </td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<br><br>
<div class="container">
	<table class="table table-striped" >
		<thead>
		<tr>
			<th> Num Demande  </th>
			<th> Nom </th>
			<th> Prénom </th>
			<th> Produit Designation </th>
			<th> Ville </th>
			<th> Adresse </th>
			<th> Téléphone </th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listdemand}" var="d">
		<tr>	
			<td> ${d.id_demande} </td>
			<td> ${d.nom } </td>
			<td> ${d.prenom } </td>
			<td> ${d.ref_produit } </td>
			<td> ${d.ville } </td>
			<td> ${d.adresse } </td>
			<td> ${d.telephone } </td>
		<!--  	<td> <a href="controlleur.php?action=delete&ref=${p.reference }" 
			onclick="if (!(confirm('Are you sure you want to delete this product ?'))) return false">Supprimer</a> </td>
			<td> <a href="controlleur.php?action=modify&ref=${p.reference}"> Modifier</a> </td>
		-->
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<footer class="text-muted">
  <div class="container">
    <p class="float-right">
      <a href="#">Back to top</a>
    </p>
    <p>Product Store Example </p>
    <p>Go to Shop Products <a href="controlleur.jee">Shop Store</a></p>
  </div>
</footer>
</body>
	<script type="text/javascript">
		$(document).ready(function () {
            setTimeout(function () {
                $('#hideit').fadeOut();
            }, 5000);
        });
	</script>
</html>