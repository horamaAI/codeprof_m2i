package fr.formation.jeu;

public class Equipe {
	private String nom;
	private Joueur[] joueurs = new Joueur[2];

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Joueur[] getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Joueur[] joueurs) {
		this.joueurs = joueurs;
	}

	public void ajouterJoueur(Joueur j) {
		// Si case 0 est vide
		if (this.joueurs[0] == null) {
			this.joueurs[0] = j;
		}

		// Sinon, on place le joueur à la case #2
		else {
			this.joueurs[1] = j;
		}
	}

	public static void demoStatic() {
		System.out.println("OK Statique");
	}
}