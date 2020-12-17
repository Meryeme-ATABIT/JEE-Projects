<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<link href="../Assets/css/bootstrap.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<aside style="border-color: grey; border-radius: 5px; border-style: inset; margin: 30px; ">
 <form style="padding: 15px; margin-bottom: 20px;" action="${pageContext.request.contextPath}/Client" method="GET" class="was-validated">
 	  <h1 style="text-align: center; margin-top: 20px; margin-bottom: 20px;">Sign in</h1>
	  <div class="form-group">
	    <label for="login">Adresse mail</label>
	    <input type="email" id="login" name="login" class="form-control"  aria-describedby="emailHelp" placeholder="Entrez votre email">	   
	  </div>
	  <div class="form-group">
	    <label for="password">Mot de passe</label>
	    <input type="password" id="password" name="password" class="form-control"  placeholder="Mot de passe">
	  </div>
	  <button type="submit" class="btn btn-dark" style="background: #0A0A0A;" >Submit</button>
	</form>
</aside>

</html>