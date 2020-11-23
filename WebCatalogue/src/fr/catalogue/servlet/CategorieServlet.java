package fr.catalogue.servlet;

import java.io.IOException;
import java.util.Hashtable;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.catalogue.beans.Categorie;
import fr.catalogue.controllers.interfaces.CatalogueRemote;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/Categorie")
public class CategorieServlet extends HttpServlet {
    
	private static final long serialVersionUID = 7621852095996823481L;


	public CategorieServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Categorie categorie = null;
		
		try {
			
			final Hashtable<String, String> jndiProprties = new Hashtable<>();
			jndiProprties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProprties);
			final String appName = "CatalogueEAR";
			final String moduleName = "WebCatalogue";
			final String beanName = "CatalogueJNDI";
			final String viewClassName = CatalogueRemote.class.getName();
			
			CatalogueRemote remote = (CatalogueRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
			
			categorie = remote.getCategorie("DVD");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("categorie",categorie);
		response.sendRedirect("/Views/Categorie.jsp");
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
