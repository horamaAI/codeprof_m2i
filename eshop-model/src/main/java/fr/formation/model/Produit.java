package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_ID")
	private int id;
	
	@Column(name = "PRO_LIBELLE", length = 50, nullable = false) //Description SQL
	@NotBlank //Vérification / validation supplémentaire
	@Size(max = 50) //Vérification / validation supplémentaire
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name = "PRO_CATEGORIE_ID")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name = "PRO_FOURNISSEUR_ID")
	private Fournisseur fournisseur;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
}