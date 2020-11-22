package beans;

	import javax.persistence.*;
	import java.io.Serializable;


	@Entity
	@Table(schema = "catalogue", name = "produit_commande")
	public class Produit_commande implements Serializable {

		private static final long serialVersionUID = 63839235168466629L;

		@Id
	    @OneToOne
	    private Commande commande;

	    @OneToOne
	    private Produit produit;

	    @Column(nullable = false)
	    private int quantite;

	    public Commande getCommande() {
	        return commande;
	    }

	    public void setCommande(Commande commande) {
	        this.commande = commande;
	    }

	    public Produit getProduits() {
	        return produit;
	    }

	    public void setProduits(Produit produits) {
	        this.produit = produits;
	    }

	    public int getQuantite() {
	        return quantite;
	    }

	    public void setQuantite(int quantite) {
	        this.quantite = quantite;
	    }
	}

