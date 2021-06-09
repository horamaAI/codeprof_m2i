package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "adresse")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADR_ID")
	private int id;
	
	@Column(name = "ADR_NUMERO_RUE", length = 5, nullable = false)
	@NotBlank
	@Size(max = 5)
	private String numeroRue;

	@Column(name = "ADR_RUE", length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String rue;
	
	@Column(name = "ADR_LIGNE_2", length = 100)
	private String ligne2;
	
	@Column(name = "ADR_LIGNE_3", length = 100)
	private String ligne3;
	
	@Column(name = "ADR_CODE_POSTAL", length = 10, nullable = false)
	@NotBlank
	@Size(max = 10)
	private String codePostal;
	
	@Column(name = "ADR_VILLE", length = 100, nullable = false)
	private String ville;
	
	@Column(name = "ADR_PAYS", length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String pays = "France";
	
	@OneToOne(mappedBy = "adressePrincipale")
	private Client clientPrincipal;
	
	@ManyToMany(mappedBy = "adresses")
	private List<Client> clients;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getLigne2() {
		return ligne2;
	}

	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	public String getLigne3() {
		return ligne3;
	}

	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Client getClientPrincipal() {
		return clientPrincipal;
	}

	public void setClientPrincipal(Client clientPrincipal) {
		this.clientPrincipal = clientPrincipal;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
}