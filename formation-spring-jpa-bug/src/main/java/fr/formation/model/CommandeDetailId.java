package fr.formation.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CommandeDetailId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "CMDE_PRODUIT_ID")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name = "CMDE_COMMANDE_ID")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name = "CMDE_ATTRIBUT_ID")
	private Attribut attribut;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Attribut getAttribut() {
		return attribut;
	}

	public void setAttribut(Attribut attribut) {
		this.attribut = attribut;
	}
}