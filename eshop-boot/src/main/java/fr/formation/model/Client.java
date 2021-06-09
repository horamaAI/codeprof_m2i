package fr.formation.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLI_ID")
	private int id;
	
	@Column(name = "CLI_NOM", length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String nom;

	@Column(name = "CLI_PRENOM", length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String prenom;

	@Column(name = "CLI_ADRESSE_MAIL", length = 150, nullable = false)
	@NotBlank
	@Size(max = 150)
	@Email
	private String email;

	@Column(name = "CLI_TELEPHONE", length = 20)
	@Size(max = 20)
//	@Pattern(regexp = "[0-9]+") //TODO : à vérifier
	private String telephone;

	@Column(name = "CLI_MOT_PASSE", length = 300, nullable = false)
	private String password;
	
	@Column(name = "CLI_DATE_NAISSANCE")
	private LocalDate dateNaissance;
	
	@OneToOne(fetch = FetchType.LAZY) //Chargement lazy pour éviter de charger l'adresse en chargeant le client
	@JoinColumn(name = "CLI_ADRESSE_ID")
	private Adresse adressePrincipale;
	
	@ManyToMany
	@JoinTable(
		name = "habitation",
		/* TABLE CLIENT */
		joinColumns = @JoinColumn(name = "HAB_CLIENT_ID", referencedColumnName = "CLI_ID"),
		/* TABLE ADRESSE */
		inverseJoinColumns = @JoinColumn(name = "HAB_ADRESSE_ID", referencedColumnName = "ADR_ID")
	)
	private List<Adresse> adresses;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdressePrincipale() {
		return adressePrincipale;
	}

	public void setAdressePrincipale(Adresse adressePrincipale) {
		this.adressePrincipale = adressePrincipale;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}
}