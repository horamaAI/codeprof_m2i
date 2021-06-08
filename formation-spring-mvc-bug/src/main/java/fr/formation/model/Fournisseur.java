package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
	
	@Column(name = "FOU_TELEPHONE", length = 20)
	@Size(max = 20)
	private String telephone;
	
	@Column(name = "FOU_ADRESSE_MAIL", length = 150, nullable = false)
	@NotBlank
	@Email
	private String email;
	
	@Column(name = "FOU_SIRET", length = 20)
	@Size(max = 20)
	private String siret;
	
	@ManyToOne
	@JoinColumn(name = "FOU_ADRESSE_ID")
	private Adresse adresse;
	
	//Relation inverse non obligatoire
	//Fetch EAGER => Charger tous les produits du fournisseur, en même temps
//	@OneToMany(mappedBy = "fournisseur", fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "fournisseur")
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}