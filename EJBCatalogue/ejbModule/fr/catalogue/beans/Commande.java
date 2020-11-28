package fr.catalogue.beans;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

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
    private Timestamp date_creation;

    @Column(nullable = false)
    private int no_confirmation;

    @OneToOne
    private Client client;

    @OneToMany
    private Collection<Produit> produits;


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

    public Timestamp getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Timestamp date_creation) {
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

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }
    
}