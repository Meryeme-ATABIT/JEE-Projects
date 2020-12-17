package fr.catalogue.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
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
import fr.catalogue.beans.Commande;
import fr.catalogue.beans.Produit;
import fr.catalogue.controllers.interfaces.CatalogueRemote;

/**
 * Servlet implementation class AjoutPanierServlet
 */
@WebServlet("/Panier")
public class AjoutPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Produit> panier = new ArrayList<>();
		Produit produit = null;
		CatalogueRemote remote = null;
		Map<String, String[]> mapParams = request.getParameterMap();
		
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
            
            if (mapParams.containsKey("add")) {
            	System.out.println("#################################ADD###########################################");
            	int id = Integer.parseInt(request.getParameter("add"));
            	produit = remote.getProduit(id);
            	panier = (List<Produit>) session.getAttribute("panier");
            	panier.add(produit);
            	session.setAttribute("panier", panier);
            	int nb = Integer.parseInt(session.getAttribute("NbPanier").toString());
            	nb = nb + 1 ;
            	session.setAttribute("NbPanier", nb);    	
            }
            if (mapParams.containsKey("vider")) {
            	System.out.println("#################################vider###########################################");
            	session.setAttribute("panier", panier);
            	session.setAttribute("total", 0);
            	session.setAttribute("NbPanier", 0); 
            	response.sendRedirect("./Views/Index.jsp");
            }
            if (mapParams.containsKey("delete")) {
            	int id = Integer.parseInt(request.getParameter("delete"));
            	panier = (List<Produit>) session.getAttribute("panier");
            	for (int i = 0; i < panier.size(); i++) {
            	    if (id == (int)panier.get(i).getId()) {
            	         panier.remove(i);
            	    }     
            	}
            	session.setAttribute("panier", panier);
            	int nb = Integer.parseInt(session.getAttribute("NbPanier").toString());
            	nb = nb - 1 ;
            	session.setAttribute("NbPanier", nb);  
            	response.sendRedirect("./Views/Panier.jsp");
            }
            if(mapParams.containsKey("valider")){
            	Client client = (Client) session.getAttribute("client");
            	if(client != null) {
            		panier = (List<Produit>) session.getAttribute("panier");
            		float montant = (float) session.getAttribute("total");
            		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            		Timestamp date_creation = new Timestamp(System.currentTimeMillis());
            		int conf = 1;
            		
            		Commande commande = (Commande) remote.CreateCommande(new Commande(montant,sdf.format(date_creation),conf, client,panier));
                	if(commande != null) {
                		session.setAttribute("NbPanier", 0);
                		session.setAttribute("total", 0);
                		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
                		List<Produit> panier1 = new ArrayList<>();
                		session.setAttribute("panier", panier1);
                		response.sendRedirect("./Views/Index.jsp");
                		}
                	else {
                		System.out.println("Eroooooorrrr");
                		response.sendRedirect("./Views/Index.jsp");
                	}
            	}
            	else {
            		response.sendRedirect("./Views/Signup.jsp");
            	}
            	
            }
            
}
}
