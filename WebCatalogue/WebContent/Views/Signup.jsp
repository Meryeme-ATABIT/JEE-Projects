<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<title>Créer compte</title>
<link href="/Assets/css/bootstrap.css" rel="stylesheet">

<%@ include file="../Layouts/header.jsp" %>
</head>
<body>
    <h1 style="text-align: center; margin-top: 20px;">Sign up</h1>
	<div class="container" style="margin-top: 20px; margin-bottom: 20px">
		<form action="${pageContext.request.contextPath}/Client" method="POST" class="was-validated">
		  <div class="form-row">
		  	 <div class="form-group col-md-6">
		  	 	<label for="inputEmail4">Nom</label>
             	<input type="text" name="nom" id="nom" class="form-control" placeholder="Nom">
             </div>
             <div class="form-group col-md-6">
             	<label for="inputEmail4">Prénom</label>
       			<input type="text" name="prenom" id="prenom" class="form-control" placeholder="Prénom">
    		</div>
		  </div>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputEmail4">Email</label>
		      <input type="email" name="email" id="email" class="form-control" id="inputEmail4" placeholder="Email">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">Mot de passe</label>
		      <input type="password" name="password" id="password" class="form-control" id="inputPassword4" placeholder="Mot de passe">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputAddress">Telephone</label>
		    <input type="text" name="telephone" id="telephone" class="form-control" id="inputAddress" placeholder="Rue, avenue ">
		  </div>
		  <div class="form-group">
		    <label for="inputAddress">Adresse</label>
		    <input type="text" name="adresse" id="adresse" class="form-control" id="inputAddress" placeholder="Rue, avenue ">
		  </div>
		
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputCity">Ville</label>
		      <input type="text" name="ville" id="ville" class="form-control" id="inputCity">
		    </div>
		   
		    <div class="form-group col-md-2">
		      <label for="inputZip">Code postal</label>
		      <input type="text" name="codePostal" id="codePostal" class="form-control" id="inputZip">
		    </div>
		  </div>
		 
		  <button type="submit" class="btn btn-dark" style="background: #0A0A0A;" >Sign in</button>
		</form>
 	</div>
<%@ include file="../Layouts/footer.jsp" %>
</body>
</html>