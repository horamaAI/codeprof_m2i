package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "[attribut]") //[] pour les mots-clés (ajouter `` en mysql par exemple)
public class Attribut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATTR_ID")
	private int id;
	
	@Column(name = "ATTR_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private AttributType type;
	
	@Column(name = "ATTR_VALEUR", length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String valeur;
	
	@ManyToOne
	@JoinColumn(name = "ATTR_PRODUIT_ID", nullable = false)
	private Produit produit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AttributType getType() {
		return type;
	}

	public void setType(AttributType type) {
		this.type = type;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
}