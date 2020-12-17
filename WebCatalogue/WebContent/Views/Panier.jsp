<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.catalogue.beans.Produit" %>
<!DOCTYPE html>
<html>
<head> 
<title>Home Page</title>
<link href="../Assets/css/bootstrap.css" rel="stylesheet">

<%@ include file="../Layouts/header.jsp" %>
 
</head>
<body>

	<div class="container">
	<%
	List<Produit> panier = (List<Produit>) session.getAttribute("panier");
	if (panier != null) {
	int id = 0;
	float total = 0;
%>
		<table class="table" style="margin-top: 20px;">
		  <thead class="thead-dark">
		    <tr style="text-align: center">
		      <th scope="col">#</th>
		      <th scope="col">Produit</th>
		      <th scope="col">Nom de produit</th>
		      <th scope="col">Prix</th>
		      <th scope="col">Quantité</th>  
		    </tr>
		  </thead>
		  <tbody>
		  <%
           
                for (Produit produit : panier) {
                	total += produit.getPrix();
                	session.setAttribute("total", total);
                	id++;
                %>  
		    <tr style="text-align: center">
		      <th scope="row"><%= id %></th>
		      <td><img class="pic1" src="../Assets/images/the_witcher.jpg" class="rounded mx-auto d-block" style=" width:25%; "></td>
		      <td><%= produit.getNom() %></td>
		      <td><%= produit.getPrix()%></td>
		      <td>1</td>
		    </tr>
		    <%
		    }
           
		    %>
		  </tbody>
		</table>
		
        <div style="text-align: right; margin-top:20px">
        	<div class="form-group">
        		<label>Total :</label>
        		<%
        		float total1 = 0;
        		for (Produit produit : panier) {
                	total1 += produit.getPrix();
        		}
        		%>
        		<span class="badge badge-pill badge-dark"> <%= total1 %> $</span>
        	</div>
        </div>
        <div style="margin-bottom: 40px; text-align: center;" >
        	<a class="btn btn-primary " href=${pageContext.request.contextPath}<%= "/Panier?valider=" %>  style="background-color: #EE0404">Valider</a>
			<a class="btn btn-secondary "  href=${pageContext.request.contextPath}<%= "/Panier?vider=" %>">Vider</a>
        </div>
	<%
            }
	else{
	%>
	<div>
	Vous n'avez ajouté aucun produit au panier
	</div>
	<%
	}
	%>
	</div>
	
    <%@ include file="../Layouts/footer.jsp" %>  
</body>
</html>