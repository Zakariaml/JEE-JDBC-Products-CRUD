<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Produit</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="headerShopStore.html" %>
<br> <br><br>

<div class="row">
		<div class="col">
			
		</div>
		<div class="col">
			<h3> Remplir le formulaire suivant pour la demande de : </h3>
			<h2>${produit.designation }</h2>
			<h1>Prix : ${produit.prix } </h1>
		</div>
		<div class="col">	
		</div>
	</div>
	
<div class="container">
	<form action="save.jee" method="post">
		<input type="hidden" name="reference" value="${produit.reference }">
  		<div class="form-group">
    		<label for="Nom">Nom : </label>
    		<input type="text" name="nom" class="form-control" id="Nom" required>
  		</div>
  		<div class="form-group">
    		<label for="prenom">Prénom : </label>
   			 <input type="text" class="form-control" id="prenom" name="prenom" required>
  		</div>
  		<div class="form-group">
   		 	<label for="ville">Ville : </label>
   			 <input type="text" class="form-control" id="ville" name="ville" required>
  		</div>
  		<div class="form-group">
  			  <label for="adresse">Adresse : </label>
   			 <input type="text" class="form-control" id="adresse" name="adresse" required>
  		</div>
  		<div class="form-group">
  			  <label for="telephone">Téléphone : </label>
  			  <input type="text" class="form-control" id="telephone" name="telephone" required>
  		</div>
  
  		<div class="form-group form-check">
    		<input type="checkbox" class="form-check-input" id="check" required>
    		<label class="form-check-label" for="check">j'accepte les conditions générales et la politique de confidentialité</label>
  		</div>
  <input type="submit" class="btn btn-primary" name="action" value="Demander">
	  </form>
</div>
	<br><br><br>
	<footer class="text-muted">
  <div class="container">
    <p class="float-right">
      <a href="#">Back to top</a>
    </p>
    <p>Product Store Example </p>
    <p>Go to Admin Page <a href="controlleur.php">Dashbord</a></p>
  </div>
</footer>
	
</body>
</html>