<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.catalogue.beans.Produit" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head> 
<title>Home Page</title>
<link href="../Assets/css/bootstrap.css" rel="stylesheet">

<%@ include file="../Layouts/header.jsp" %>  
</head>
<body>
		<%
            String CategorieName = (String)session.getAttribute("CategorieName");
                %>
    <div class="card-header text-center">
      <h2>Catégorie : <%=CategorieName %></h2> 
    </div>
	<div class="row" style = "margin-top: 6px;">
	  <div class="col-8">
		<div class="container">
		  <div class="row">
		  <%
            List<Produit> produits = (List<Produit>) session.getAttribute("produits");
            if (produits != null) {
                for (Produit produit : produits) {
                %>      
                  <div class="col-sm">
		          <div class="card" style="width: 18rem;">
				  <img class="ml-2"  src="/Assets/images/cd1.png" width="200" height="200" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title"><%=produit.getNom() %></h5>
				    <p class="card-text"><%=produit.getDescription() %></p>
				    <a href="#" class="btn btn-primary" style="background: #0A0A0A;">Ajouter au panier</a>
				  </div>
				</div>
		    </div>
                <%
                }
            } 
        %>
		    
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