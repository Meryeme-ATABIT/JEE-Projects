package fr.catalogue.servlet;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.catalogue.beans.Client;
import fr.catalogue.controllers.interfaces.CatalogueRemote;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/Client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = null;
		Map<String, String[]> mapParams = request.getParameterMap();
		CatalogueRemote remote = null;
            try {
				final Hashtable<String, String> jndiProprties = new Hashtable<>();
				jndiProprties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
				final Context context = new InitialContext(jndiProprties);
				final String appName = "EARCatalogue";
				final String moduleName = "EJBCatalogue";
				final String beanName = "CatalogueJNDI";
				final String viewClassName = CatalogueRemote.class.getName();
				remote = (CatalogueRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
		
            } catch(Exception e) {
            	e.printStackTrace();
            }
            
           //si le client veut se connecter
            if (mapParams.containsKey("login") && remote != null) {
            	//recuperer les parametres
            	String email = request.getParameter("login");
        		String password = request.getParameter("password");
            	client = (Client) remote.getClient(email, password);
            	
            	System.out.println("\nLogin : " + client.getEmail() + " / password " + client.getPassword() );
            	
            	if(client != null) {
            		session.setAttribute("client", client);
            		response.sendRedirect("./Views/Index.jsp");
            	}else {
            		response.sendRedirect("./Views/Produit.jsp");
                }   	
            }
            //si le client veut s'inscrire
            if(mapParams.containsKey("nom") && remote != null) {
            	//recuperer les parametres
            	String nom = request.getParameter("nom");
        		String prenom = request.getParameter("prenom");
        		String email = request.getParameter("email");
        		String password = request.getParameter("password");
        		String adresse = request.getParameter("adresse") + request.getParameter("ville") + request.getParameter("codePostal") ;
        		String telephone = request.getParameter("telephone");
            	client = (Client) remote.CreateClient(new Client(nom, prenom, email, telephone, password, adresse));
            	if(client != null) {
            		session.setAttribute("client", client);
            		response.sendRedirect("./Views/Index.jsp");
            		}
            	else {
            		//message toast
            	}
            }
            if(mapParams.containsKey("logout")) {
            	 request.getSession(true).setAttribute("client", null);
            	 response.sendRedirect("./Views/Index.jsp");
            }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		doGet(request, response);
	}

}
