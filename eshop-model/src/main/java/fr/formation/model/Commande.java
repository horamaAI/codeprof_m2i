package fr.formation.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CMD_ID")
	private int id;
	
	@Column(name = "CMD_DATE", nullable = false)
	private LocalDateTime date = LocalDateTime.now();
	
	@Column(name = "CMD_TOTAL", precision = 10, scale = 2, nullable = false)
	private BigDecimal total;
	
	@Column(name = "CMD_ETAT", nullable = false)
	@Enumerated(EnumType.STRING)
	private CommandeEtat etat;
	
	@ManyToOne
	@JoinColumn(name = "CMD_CLIENT_ID", nullable = false)
	private Client client;

	@ManyToOne
	@JoinColumn(name = "CMD_ADRESSE_ID", nullable = false)
	private Adresse adresse;
	
	@OneToMany(mappedBy = "id.commande")
	private List<CommandeDetail> details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public CommandeEtat getEtat() {
		return etat;
	}

	public void setEtat(CommandeEtat etat) {
		this.etat = etat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<CommandeDetail> getDetails() {
		return details;
	}

	public void setDetails(List<CommandeDetail> details) {
		this.details = details;
	}
}