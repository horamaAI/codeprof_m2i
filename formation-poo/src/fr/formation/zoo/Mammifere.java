package fr.formation.zoo;

public class Mammifere extends Animal {
	private CouleurAnimal couleur;

	public CouleurAnimal getCouleur() {
		return couleur;
	}

	public void setCouleur(CouleurAnimal couleur) {
		this.couleur = couleur;
	}
	
	public void courrir() {
		System.out.println("Le mammifère court ...");
	}
}