package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.projection.Views;

@Entity
@Table(name = "categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAT_ID")
	@JsonView(Views.Common.class)
	private int id;

	@Column(name = "CAT_LIBELLE", length = 50, nullable = false)
	@NotBlank
	@Size(min = 3, max = 50)
	@JsonView(Views.Categorie.class)
	private String libelle;

	@Column(name = "CAT_DESCRIPTION")
	@Lob // Longue donnée - gros volume d'informations
	private String description;

//	private int parentId;
	
	@ManyToOne
	@JoinColumn(name = "CAT_PARENT_ID")
	@JsonView(Views.CategorieDetailed.class)
	private Categorie parent;
	
	@OneToMany(mappedBy = "parent")
	private List<Categorie> enfants;
	
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getParent() {
		return parent;
	}

	public void setParent(Categorie parent) {
		this.parent = parent;
	}

	public List<Categorie> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Categorie> enfants) {
		this.enfants = enfants;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}