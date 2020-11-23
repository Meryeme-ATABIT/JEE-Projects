package fr.catalogue.controllers.interfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.catalogue.beans.Categorie;
import fr.catalogue.beans.Client;
import fr.catalogue.beans.Commande;
import fr.catalogue.beans.Produit;

@Remote
public interface CatalogueRemote {
	//Categorie
	Categorie getCategorie(String name);
	List<Categorie> getCategories();
	List<Produit> getCategorieProduits(long id);
	
	//Produit
	Produit getProduit(long id);
	
	//Commande
	Commande getCommande(long id);
	void CreateCommande(Commande commande);
	
	
	//Client
	Client getClient(long id);
	void CreateClient(Client client);
}

