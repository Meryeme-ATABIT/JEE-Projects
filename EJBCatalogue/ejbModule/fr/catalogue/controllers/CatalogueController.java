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
	
	public Categorie getCategorie(String name) {
		Query q = manager.createQuery("SELECT c FROM Categorie c WHERE c.nom=:name").setParameter("name", name);
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
	
	public Client getClient(long id) {
		Query q = manager.createQuery("SELECT c FROM Client WHERE c.id=:id").setParameter("id", id);
		Client client = (Client) q.getSingleResult();
		return client;
	}
	
	
	public List<Categorie> getCategories(){
		Query q = manager.createQuery("SELECT c FROM Categorie c");
		List<Categorie> categories =  q.getResultList();
		return categories;
	}
	
	public List<Produit> getCategorieProduits(long id){
		List<Produit> produits = null;
		
		
		return produits;
	}
	
	public void CreateCommande(Commande commande) {
		
	}

	@Override
	public void CreateClient(Client client) {
		// TODO Auto-generated method stub
		
	}
}
