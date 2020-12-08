<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<title>Home Page</title>
<link href="/Assets/css/bootstrap.css" rel="stylesheet">

<%@ include file="../Layouts/header.jsp" %>
</head>
<body>
	<div class="row" style = "margin-top: 6px;">
	  <div class="col-9">
		<div class="card">
		  <div class="card-header text-center">
		    Bienvenue !
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