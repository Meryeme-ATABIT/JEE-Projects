<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="fr.catalogue.beans.Categorie" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="row row-cols-1 row-cols-md-3">

       <%
            List<Categorie> categories = (List<Categorie>) session.getAttribute("categories");
            if (categories != null) {
                for (Categorie cat : categories) {
                %>      
                                     <h5 class="card-title"> <%=cat.getNom() %> </h5>
                <%
                }
            } else {
                    // TODO : when the categories empty
                    }
        %>
      
                

    </div>
</body>
</html>