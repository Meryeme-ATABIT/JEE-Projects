<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.catalogue.beans.Produit" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head> 
<title>Home Page</title>
<link href="../Assets/css/bootstrap.css" rel="stylesheet">
 <script src="../Assets/js/scripts.js"></script> 
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
	  <div <% if(session.getAttribute("client") == null) { %>class="col-9"<% } else { %>class="col-12" <% } %> >
		<div class="container">
		  <div class="row">
		  <%
            List<Produit> produits = (List<Produit>) session.getAttribute("produits");
            if (produits != null) {
                for (Produit produit : produits) {
                %>  
                 <div class="col-" style="margin: 30px;">
				        
				            <div class="card card-1" style=" padding:20px;">
				                <div class="pr-3 row justify-content-end">
				                    <div class="fa fa-heart-o like"></div>
				                </div>
				                <div class="product-pic"> <img class="pic1" src="../Assets/images/the_witcher.jpg"> </div> <small class="category"><%=produit.getDescription() %></small>
				                <h5 class="product-name"><%=produit.getNom() %></h5>
				                <div class="row px-3 justify-content-between">
				                    <p class="price"><%=produit.getPrix()%></p>
				                    <div class="stars"> <span class="fa fa-star star-active"></span> <span class="fa fa-star star-active"></span> <span class="fa fa-star star-active"></span> <span class="fa fa-star-o"></span> <span class="fa fa-star-o"></span> </div>
				                    <button id="addProduct" onclick=<%= "addToPanier(" + produit.getId() + ")" %> class="btn btn-primary" style="background: #0A0A0A;">Ajouter au panier</button>
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
	  <%
            
            if (session.getAttribute("client") == null) {
               
                %>   
	  <div class="col-3">
	  <%@ include file="../Layouts/aside.jsp" %>  
	  </div>
	  <% } %>
	</div>
    <%@ include file="../Layouts/footer.jsp" %> 
   
</body>
</html>