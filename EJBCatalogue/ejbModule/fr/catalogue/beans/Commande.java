package fr.catalogue.beans;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(schema = "catalogue", name = "commandes")
public class Commande implements Serializable {

     /**
	 * 
	 */
	private static final long serialVersionUID = -7614511943449374529L;

	@Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private float montant;

    @Column(nullable = false)
    private String date_creation;

    @Column(nullable = false)
    private int no_confirmation;

    @OneToOne
    private Client client;

    @OneToMany
    private List<Produit> produits;
    
    public Commande() {
    	super();
    }
    public Commande(float montant, String date_creation, int conf, Client client, List<Produit> panier) {
 
    	   this.montant = montant;
           this.date_creation = date_creation;
           this.no_confirmation = conf;
           this.client = client;
           this.produits = panier;
    }
  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public int getNo_confirmation() {
        return no_confirmation;
    }

    public void setNo_confirmation(int no_confirmation) {
        this.no_confirmation = no_confirmation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
}