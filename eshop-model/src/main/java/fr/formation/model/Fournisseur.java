package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOU_ID")
	private int id;
	
	@Column(name = "FOU_NOM", length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String nom;
	
	//Relation inverse non obligatoire
	//Fetch EAGER => Charger tous les produits du fournisseur, en même temps
	@OneToMany(mappedBy = "fournisseur", fetch = FetchType.EAGER)
	private List<Produit> produits;

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

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}