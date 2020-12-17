<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
	<title>Home Page</title>
	<link href="/Assets/css/bootstrap.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
	<%@ include file="../Layouts/header.jsp" %>
</head>
<body>
	<div class="row" style = "margin-top: 6px;">
	  <div class="col-9">
	    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="/Assets/images/carousel2.jpg" alt="First slide" >
		      <div class="carousel-caption d-none d-md-block">
				 <h2><b>Bienvenue chez OnlineShop </b></h2>
				 <p>"Le commerce vous ouvre son coeur !"</p>
  			 </div>
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="/Assets/images/carousel1.jpg" alt="Second slide">
		      <div class="carousel-caption d-none d-md-block">
				 <h2><b>Bienvenue chez OnlineShop </b></h2>
				 <p>"Le commerce vous ouvre son coeur !"</p>
  			 </div>
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="/Assets/images/carousel4.jpg" alt="Third slide">
		        <div class="carousel-caption d-none d-md-block">
				    <h2><b>Bienvenue chez OnlineShop </b></h2>
				    <p>"Le commerce vous ouvre son coeur !"</p>
  				</div>
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
		<div class="card">
		  <div class="card-header text-center">
		    Vous trouvez : 
		  </div>
		  <div class="card-body">
		    <blockquote class="blockquote mb-0">
				<div class="container">
				  <div class="row">
				    <div class="col-sm">
				      <img src="/Assets/images/36836-1-dvd-transparent-image.png" class="rounded mx-auto d-block " width="200 200"  >
				    </div>
				    <div class="col-sm">
				     <img src="/Assets/images/Edwards-rel.png" class="rounded mx-auto d-block" width="200 200" >
				    </div>
				    <div class="col-sm">
				      <img src="/Assets/images/unnamed.png" class="rounded mx-auto d-block " width="200 200" >
				    </div>
				  </div>
                </div>
				<div class="container">
				  <div class="row">
				    <div class="col-sm text-center">
				      DVD
				    </div>
				    <div class="col-sm text-center">
				      Livres
				    </div>
				    <div class="col-sm text-center">
				      CD
				    </div>
				  </div>
				</div>
		    </blockquote>
		  </div>
		</div>
	  </div>
	  <div class="col-3">
	  <%@ include file="../Layouts/aside.jsp" %>
	  </div>
	</div>
    <%@ include file="../Layouts/footer.jsp" %>
</body>
</html>