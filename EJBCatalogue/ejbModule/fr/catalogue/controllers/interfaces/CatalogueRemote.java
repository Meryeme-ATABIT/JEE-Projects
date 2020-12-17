package fr.catalogue.controllers.interfaces;

import fr.catalogue.beans.Categorie;
import fr.catalogue.beans.Client;
import fr.catalogue.beans.Commande;
import fr.catalogue.beans.Produit;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CatalogueRemote {
	//Categorie
	Categorie getCategorie(int id);
	Categorie getCategorieByName(String name);
	List<Categorie> getCategories();
	List<Produit> getCategorieProduits(Categorie categorie);
	
	//Produit
	Produit getProduit(long id);
	
	//Commande
	Commande getCommande(long id);
	Commande CreateCommande(Commande commande);
	
	
	//Client
	Client getClient(String email, String password);
	
	Client CreateClient(Client client);
}

