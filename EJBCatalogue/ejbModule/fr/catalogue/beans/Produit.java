package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(schema ="catalogue", name ="produits")
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8768048751545623097L;
        
	    @Id
	    @GeneratedValue
	    @Column(nullable = false)
		private long id;
		
	    @Column(nullable = false)
		private String nom;
		
	    @Column(nullable = false)
		private float prix;
		
	    @Column(nullable = false)
		private String description;
		
	    @Column
		private Date dernier_maj;
		
	    @OneToOne
		private Categorie categorie;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public float getPrix() {
			return prix;
		}

		public void setPrix(float prix) {
			this.prix = prix;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getDernier_maj() {
			return dernier_maj;
		}

		public void setDernier_maj(Date dernier_maj) {
			this.dernier_maj = dernier_maj;
		}

		public Categorie getCategorie() {
			return categorie;
		}

		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}
	
	    
}
