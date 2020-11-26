<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
<meta charset="ISO-8859-1">
<title>Modifier un produit</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
	</head>
	<body>
<%@ include file="header.html" %>
<br><br><br><br>

<div class="container">
	
<a href="controller.php" class="btn btn-secondary float-right"> Annuler</a>	
		<c:choose> 
			<c:when test="${product.reference != null}">
				<h2>Modification de produit ${product.designation} : </h2>
			</c:when>
			<c:otherwise>
				<h2> Ajouter un produit : </h2>
			</c:otherwise>
		</c:choose>

	<div class="row">
	
	<form action="controlleur.php" method="post" enctype="multipart/form-data" >
  		<div class="form-group">
  			<c:choose>
				<c:when test="${product.reference != null}">
				<label for="reference"> Reference : </label>
				<input name="reference" id="reference" class="form-control" value="${product.reference } " readonly>
			</c:when>
			<c:otherwise>
				<label for="reference"> Reference : </label>
				<input name="reference" id="reference" class="form-control" value="${product.reference } " required>
				<input type="hidden" name="addORsave" value="add">
			</c:otherwise>
	</c:choose>
  		</div>
  		<div class="form-group">
  			<label for="designation"> Designation : </label> 
  			<input name="designation" id="designation" class="form-control" value="${product.designation }" required>
  		</div>
  		<div class="form-group">
  			<label for="prix"> Prix : </label> 
  			<input name="prix" id="prix" class="form-control" value="${product.prix }" required>
  		</div>
  		<div class="form-group">
  			<label for="quantite"> Quantité :</label>
  			<input name="quantite" id="quantite" class="form-control" value="${product.quantite }" required>
  		</div>
  		<div class="form-group">
  			<label for="warehouse"> Location warehouse : </label>
  			<input name="warehouse_ref" id="warehouse" class="form-control" value="${product.warehouse_ref}" required>
  		</div>
  		<div class="form-group">
  			<label> Image de produit :</label>
  			<label> ${product.filename}</label>
  			
  			<input type="file" name="image" id="file" class="form-control" value="${product.filepath}">
 		 </div>
 		 <!-- <input type="hidden" id="checkfile" name="checkIfFileSelected" value="">
 		 function ffff() {
		if( document.getElementById("file").files.length != 0 ){
			document.getElementByID("checkfile").value = "selected";
		}		
	}
 		 
 		  -->
  	<button type="submit" name="action" value="save" class="btn btn-primary">Sauvgarder</button>
	</form>	
	
	</div>
	
</div>		
		<br><br>
	<footer class="text-muted">
  <div class="container">
    <p class="float-right">
      <a href="#">Back to top</a>
    </p>
    <p>Product Store Example </p>
    <p>Go to Shop Products <a href="controlleur.jee">Shop Store</a></p>
  </div>
</footer>	

	<!-- <form action="controlleur.php" method="post" enctype="multipart/form-data" >
		<c:choose>
			<c:when test="${product.reference != null}">
			Reference : <input name="reference" value="${product.reference } " readonly>
			</c:when>
			<c:otherwise>
			Reference : <input name="reference" value="${product.reference } ">
			<input type="hidden" name="addORsave" value="add">
			</c:otherwise>
		</c:choose>
		Designation : <input name="designation" value="${product.designation }">
		Prix : <input name="prix" value="${product.prix }">
		Quantité : <input name="quantite" value="${product.quantite }">
		Location warehouse : <input name="warehouse_ref" value="${product.warehouse_ref }">
		Image de produit : <input type="file" name="image" value="${product.filepath }">
		
		<input type="submit" name="action" value="save">
	</form>
	 -->		
	
</body>
	
	<script type="text/javascript">
	
	
	</script>
	
	
</html>