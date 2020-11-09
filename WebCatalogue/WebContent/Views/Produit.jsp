<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<title>Home Page</title>
<link href="../Assets/css/bootstrap.css" rel="stylesheet">

<%@ include file="../Layouts/header.jsp" %>  
</head>
<body>
    <div class="card-header text-center">
      <h2>Catégorie : CD</h2> 
    </div>
	<div class="row" style = "margin-top: 6px;">
	  <div class="col-8">
		<div class="container">
		  <div class="row">
		    <div class="col-sm">
		      <div class="card" style="width: 18rem;">
				  <img class="ml-2"  src="../Assets/images/cd1.png" width="200" height="200" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">Card title</h5>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="#" class="btn btn-primary" style="background: #0A0A0A;">Ajouter au panier</a>
				  </div>
				</div>
		    </div>
		    <div class="col-sm">
		      <div class="card" style="width: 18rem;">
				  <img class="ml-2"  src="../Assets/images/cd1.png" width="200" height="200" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">Card title</h5>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="#" class="btn btn-primary" style="background: #0A0A0A;">Ajouter au panier</a>
				  </div>
				</div>
		    </div>
		    <div class="col-sm">
		      <div class="card" style="width: 18rem;">
				  <img class="ml-2"  src="../Assets/images/cd1.png" width="200" height="200" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">Card title</h5>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="#" class="btn btn-primary" style="background: #0A0A0A;">Ajouter au panier</a>
				  </div>
				</div>
		    </div>
		  </div>
		</div>
	  </div>
	  <div class="col-4">
	  <%@ include file="../Layouts/aside.jsp" %>  
	  </div>
	</div>
    <%@ include file="../Layouts/footer.jsp" %>  
</body>
</html>