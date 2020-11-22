package controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Categorie;
import controllers.interfaces.CatalogueLocal;
import controllers.interfaces.CatalogueRemote;

@Stateless(name = "CatalogueJNDI")
public class CatalogueController implements CatalogueLocal, CatalogueRemote {
	
	@PersistenceContext(unitName="catalogueManager")
	EntityManager manager;
	
	public Categorie getCategorie(String name) {
		Query q = manager.createQuery("SELECT c FROM Categorie c");
		Categorie categoriebean = (Categorie) q.getSingleResult();
		return categoriebean;
	}
}
