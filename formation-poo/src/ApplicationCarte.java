import java.util.ArrayList;

public class ApplicationCarte {
	public static void main(String[] args) {
//		Carte[] mesCartes = new Carte[32];
		ArrayList<Carte> mesCartes = new ArrayList<>();
//		Joueur[] mesJoueurs = new Joueur[4];
		ArrayList<Joueur> mesJoueurs = new ArrayList<>();
//		Equipe[] mesEquipes = new Equipe[2];
		ArrayList<Equipe> mesEquipes = new ArrayList<>();
		
		//32 fois : création d'une carte, affecter son nom & sa valeur
		for (int i = 0; i < 32; i++) {
			//Création de la carte
			Carte maCarte = new Carte();
			
//			maCarte.nom = "Carte #" + i;
			maCarte.setNom("Carte #" + i);
			maCarte.setValeur(i);
			
			//On donne la carte au tableau de cartes
//			mesCartes[i] = maCarte;
			mesCartes.add(maCarte);
		}
		
		//Parcours des cartes : pour
		for (int i = 0; i < mesCartes.size(); i++) {
			System.out.println( mesCartes.get(i).getNom() );
		}
		
		//Parcours des cartes : pour chaque
		for (Carte c : mesCartes) {
			System.out.println( c.getNom() );
		}
		
		
		
		for (int i = 0; i < 4; i++) {
			Joueur monJoueur = new Joueur();
			
			monJoueur.nom = "Joueur #" + i;
			
//			mesJoueurs[i] = monJoueur;
			mesJoueurs.add(monJoueur);
		}
		
		for (int i = 0; i < 2; i++) {
			mesEquipes.add(new Equipe());
//			mesEquipes.get(i).nom = "Equipe #" + i;
			mesEquipes.get( mesEquipes.size() - 1 ).nom = "Equipe #" + i;
		}
		
		//On associe les joueurs aux équipes
		Equipe equipeA = mesEquipes.get(0);
		equipeA.ajouterJoueur(mesJoueurs.get(0));
		equipeA.ajouterJoueur(mesJoueurs.get(1));

		Equipe equipeB = mesEquipes.get(1);
		equipeB.ajouterJoueur(mesJoueurs.get(2));
		equipeB.ajouterJoueur(mesJoueurs.get(3));
		
		System.out.println( mesEquipes.get(0).joueurs[0].nom );
		
		Equipe.demoStatic();
		
		ApplicationCarte app = new ApplicationCarte();
		app.demo2();
//		demo2(); //Pas possible car pas static
	}
	
	static void demo() {
		
	}
	
	void demo2() {
		
	}
}