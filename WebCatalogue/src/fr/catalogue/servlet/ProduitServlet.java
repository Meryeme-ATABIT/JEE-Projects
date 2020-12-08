package fr.catalogue.servlet;

import fr.catalogue.beans.Categorie;
import fr.catalogue.beans.Produit;
import fr.catalogue.controllers.interfaces.CatalogueRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/Produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Produit> produits = null;
		Categorie categorie = null;
		Map<String, String[]> mapParams = request.getParameterMap();
		if (mapParams.containsKey("id")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
				final Hashtable<String, String> jndiProprties = new Hashtable<>();
				jndiProprties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
				final Context context = new InitialContext(jndiProprties);
				final String appName = "EARCatalogue";
				final String moduleName = "EJBCatalogue";
				final String beanName = "CatalogueJNDI";
				final String viewClassName = CatalogueRemote.class.getName();
				CatalogueRemote remote = (CatalogueRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
				categorie = remote.getCategorie(id);
				produits = remote.getCategorieProduits(categorie);
			
            } catch(Exception e) {
            	e.printStackTrace();
            }
        session.setAttribute("CategorieName", categorie.getNom());
		session.setAttribute("produits", produits);
		response.sendRedirect("./Views/Produit.jsp");
	}
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
