package fr.formation.jeu;

public class Carte {
	private int valeur = 0;
	private String nom;
	
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		if (valeur > 0) {
			this.valeur = valeur;	
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}