package fr.formation.model;

import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.projection.Views;

@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name = "PRO_LIBELLE", length = 50, nullable = false) //Description SQL
	@NotBlank(message = "Attention, le libellé ne peut pas être vide !!!!!!") //Vérification / validation supplémentaire
	@Size(max = 50) //Vérification / validation supplémentaire
	@JsonView(Views.Produit.class)
	private String libelle;
	
	@Column(name = "PRO_PRIX", precision = 10, scale = 2, nullable = false)
	@NotNull(message = "Le prix peut pas être nul")
	@Positive
	@JsonView(Views.Produit.class)
	private BigDecimal prix;
	
	@Column(name = "PRO_STOCK", nullable = false)
	private int stock;
	
	@Column(name = "PRO_IMAGE", length = 255)
	@Size(max = 255)
	private String image;
	
	@Column(name = "PRO_PRIX_ACHAT", precision = 10, scale = 2, nullable = false)
	@NotNull(message = "Le prix d''achat doit être saisi")
	@JsonView(Views.ProduitDetailed.class)
	private BigDecimal prixAchat;
	
	@Column(name = "PRO_DESCRIPTION")
	@Lob
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "PRO_CATEGORIE_ID")
	@JsonView(Views.ProduitDetailed.class)
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name = "PRO_FOURNISSEUR_ID")
	@JsonView(Views.ProduitDetailed.class)
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy = "id.produit")
	private List<CommandeDetail> details;

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

	public List<CommandeDetail> getDetails() {
		return details;
	}

	public void setDetails(List<CommandeDetail> details) {
		this.details = details;
	}
}