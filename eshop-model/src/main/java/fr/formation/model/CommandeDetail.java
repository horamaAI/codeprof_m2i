package fr.formation.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "commande_detail")
public class CommandeDetail {
	@EmbeddedId
	private CommandeDetailId id;

	@Column(name = "CMDE_QUANTITE", nullable = false)
	private int quantite;

	@Column(name = "CMDE_PRIX_UNITAIRE", precision = 10, scale = 2, nullable = false)
	private BigDecimal prixUnitaire;

	public CommandeDetailId getId() {
		return id;
	}

	public void setId(CommandeDetailId id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
}