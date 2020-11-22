package controllers.interfaces;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Remote;

import beans.Categorie;
import beans.Client;
import beans.Commande;
import beans.Produit;

@Remote
public interface CatalogueRemote {
	//Categorie
	Categorie getCategorie(String name);
	ArrayList<Categorie> getCategories();
	
	//Produit
	Produit getProduit(long id);
	
	//Commande
	Commande getCommande(long id);
	void CreateCommande(Commande commande);
	
	
	//Client
	Client getClient(long id);
	void CreateClient(Client client);
}

