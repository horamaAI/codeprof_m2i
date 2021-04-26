
public class Equipe {
	String nom;
	Joueur[] joueurs = new Joueur[2];
	
	void ajouterJoueur(Joueur j) {
		//Si case 0 est vide
		if (this.joueurs[0] == null) {
			this.joueurs[0] = j;
		}
		
		//Sinon, on place le joueur à la case #2
		else {
			this.joueurs[1] = j;
		}
	}
	
	static void demoStatic() {
		System.out.println("OK Statique");
	}
}