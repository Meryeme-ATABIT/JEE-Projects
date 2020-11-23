package fr.catalogue.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "catalogue", name="categories")
public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5238606859049766331L;
	
	@Id
	@GeneratedValue
	@Column(nullable=false)
	private int id;
	
	@Column(nullable=false)
	private String nom;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
}
