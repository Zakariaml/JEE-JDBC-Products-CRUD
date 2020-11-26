<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Shop list</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<%@ include file="headerShopStore.html" %>
	<br><br><br>
<main role="main">
<div class="container"> 	
	<div class="row"> 
	<c:forEach items="${allprod}" var="p">
		<div class="col-md-4">
          <div class="card mb-4 shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" 
            xmlns="" preserveAspectRatio="xMidYMid slice" 
            focusable="false" role="img" aria-label="Placeholder: Thumbnail">
            <title>Placeholder</title>
            <img src="${p.filepath}">
            </svg>
            <div class="card-body">
              <p class="card-text">
              <ul> 
              	<li>${p.designation} </li>
              	<li>Prix : ${p.prix }   </li>
              	<li>Quantité : ${p.quantite}  </li>
              </ul>
              </p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <a href="BuyNow.jee?action=buy&reference=${p.reference }" class="btn btn-sm btn-outline-secondary">Demander</a>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
	</c:forEach> 
	</div>
</div>
</main>
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