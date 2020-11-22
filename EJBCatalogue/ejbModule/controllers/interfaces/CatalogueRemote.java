package controllers.interfaces;

import javax.ejb.Remote;

import beans.Categorie;

@Remote
public interface CatalogueRemote {
	Categorie getCategorie(String name);
}
