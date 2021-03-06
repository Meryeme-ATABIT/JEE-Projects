<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.catalogue.beans.Categorie" %>
    <%@ page import="fr.catalogue.beans.Client" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Catégorie</title>
		<link href="../Assets/css/bootstrap.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</head>
	
	<header class="header">
		<nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #0A0A0A;">
			  <a class="navbar-brand" href="#"><img src="/Assets/images/897ecbc4de52bcc013dbd15bf148edc7.png" class="rounded float-left" width ="150 90"></a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			      <li class="nav-item active">
			        <a class="nav-link" href="${pageContext.request.contextPath}/Views/Index.jsp">Home <span class="sr-only">(current)</span></a>
			      </li>
			      <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/Index" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Catégorie
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			         <%
            			List<Categorie> categories = (List<Categorie>) session.getAttribute("categories");
            			if (categories != null) {
                			for (Categorie cat : categories) {
                				System.out.println(cat.getNom());
                				%>      
	                				<a class="dropdown-item" href=${pageContext.request.contextPath}<%= "/Produit?id=" + cat.getId() %>><%=cat.getNom() %></a>
				          			<div class="dropdown-divider"></div>
                				<%
               				 }
	            		} 
        			%>
			        </div>
			      </li>
			    </ul>
			    <form class="form-inline my-2 my-lg-0">
			    <%
			    Client client = (Client) session.getAttribute("client");
			    if(client == null){
			    %>
			      <li class="nav-item" style="margin-bottom: 10px">
			        <a class="nav-link disabled" href=${pageContext.request.contextPath}/Views/Signup.jsp>S'inscrire</a>
			      </li>
			    <%
			    }
			    else{
			      %>
			      <li class="nav-item" style="margin-bottom: 10px">
			        <a class="nav-link disabled" href=${pageContext.request.contextPath}<%= "/Client?logout=" %>>Deconnexion</a>
			      </li>
			      <%
			    }
			    int nb = Integer.parseInt(session.getAttribute("NbPanier").toString());
			   
			    System.out.println(nb);
			    if(nb > 0){
			      %>
			      <li class="nav-item" style="margin-bottom: 10px">
			        <a class="nav-link disabled" href=${pageContext.request.contextPath}/Views/Panier.jsp>Panier<span class="badge badge-danger">  <%= " " + nb %></span></a>
			      </li>
			      <% 
			    }
			    else{
			      %>
			      <li class="nav-item" style="margin-bottom: 10px">
			        <a class="nav-link disabled" href=${pageContext.request.contextPath}/Views/Panier.jsp>Panier</a>
			      </li>
			      <%
			    }
			      %>
					<svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-basket-fill" fill="#EE0404" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M5.071 1.243a.5.5 0 0 1 .858.514L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15.5a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5H15v5a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V9H.5a.5.5 0 0 1-.5-.5v-2A.5.5 0 0 1 .5 6h1.717L5.07 1.243zM3.5 10.5a.5.5 0 1 0-1 0v3a.5.5 0 0 0 1 0v-3zm2.5 0a.5.5 0 1 0-1 0v3a.5.5 0 0 0 1 0v-3zm2.5 0a.5.5 0 1 0-1 0v3a.5.5 0 0 0 1 0v-3zm2.5 0a.5.5 0 1 0-1 0v3a.5.5 0 0 0 1 0v-3zm2.5 0a.5.5 0 1 0-1 0v3a.5.5 0 0 0 1 0v-3z"/>
					</svg>
			    </form>
			  </div>
		</nav>
	</header>
<body ></body>
