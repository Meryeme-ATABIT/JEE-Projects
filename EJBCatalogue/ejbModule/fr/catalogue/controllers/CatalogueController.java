package fr.catalogue.controllers;

import fr.catalogue.beans.Categorie;
import fr.catalogue.beans.Client;
import fr.catalogue.beans.Commande;
import fr.catalogue.beans.Produit;
import fr.catalogue.controllers.interfaces.CatalogueLocal;
import fr.catalogue.controllers.interfaces.CatalogueRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "CatalogueJNDI")
public class CatalogueController implements CatalogueLocal, CatalogueRemote {
	
	@PersistenceContext(unitName="catalogueManager")
	EntityManager manager;
	
	public Categorie getCategorie(int id) {
		Query q = manager.createQuery("SELECT c FROM Categorie c WHERE c.id=:id").setParameter("id", id);
		Categorie categoriebean = (Categorie) q.getSingleResult();
		return categoriebean;
	}
	
	public Produit getProduit(long id) {
		Query q = manager.createQuery("SELECT c FROM Produit WHERE c.id=:id").setParameter("id", id);
		Produit produit = (Produit) q.getSingleResult();
		return produit;
	}
	
	public Commande getCommande(long id) {
		Query q = manager.createQuery("SELECT c FROM Commande WHERE c.id=:id").setParameter("id", id);
		Commande commande = (Commande) q.getSingleResult();
		return commande;
	}
	
	public Client getClient(String email, String password) {
		Query q = manager.createQuery("SELECT c FROM Client c WHERE c.email=:em AND c.password=:ps").setParameter("em", email).setParameter("ps", password);
		try {
			 Client client = (Client) q.getSingleResult();
			 System.out.println("--------------------------------------------------------------------------------------------------");
			 return client;
		} catch(Exception e) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			e.printStackTrace();
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return null;
		}
	}
	
	
	public List<Categorie> getCategories(){
		Query q = manager.createQuery("SELECT c FROM Categorie c");
		List<Categorie> categories =  q.getResultList();
		return categories;
	}
	
	public List<Produit> getCategorieProduits(Categorie categorie){
		Query q = manager.createQuery("SELECT c FROM Produit c WHERE c.categorie=:categorie").setParameter("categorie", categorie);
		List<Produit> produits =  q.getResultList();
		
		
		return produits;
	}
	
	public void CreateCommande(Commande commande) {
		
	}

	@Override
	public Client CreateClient(Client client) {
		try {
            manager.persist(client);
            return client;
        } catch (Exception e) {
            return null;
        }
	}
}
