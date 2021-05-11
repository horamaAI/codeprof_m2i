package fr.formation.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
	
	@Column(name = "PRO_PRIX", precision = 10, scale = 2, nullable = false)
	@NotNull
	private BigDecimal prix;
	
	@Column(name = "PRO_STOCK", nullable = false)
	private int stock;
	
	@Column(name = "PRO_IMAGE", length = 255)
	@Size(max = 255)
	private String image;
	
	@Column(name = "PRO_PRIX_ACHAT", precision = 10, scale = 2, nullable = false)
	@NotNull
	private BigDecimal prixAchat;
	
	@Column(name = "PRO_DESCRIPTION")
	@Lob
	private String description;
	
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

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(BigDecimal prixAchat) {
		this.prixAchat = prixAchat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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