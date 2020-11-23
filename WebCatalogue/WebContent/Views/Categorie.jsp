<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="fr.catalogue.beans.Categorie" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="row row-cols-1 row-cols-md-3">

        <%
            Categorie cat = (Categorie) session.getAttribute("categorie");
            
                %>
                    <div class="col mb-4">
                        <div class="card">
                            
                            <div class="card-body">
                            <h5 class="card-title"> <%=cat.getId() %> </h5>
                                <h5 class="card-title"> <%=cat.getNom() %> </h5>
                 
                            </div>
                        </div>
                    </div>
                

    </div>
</body>
</html>