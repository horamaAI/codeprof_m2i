package fr.formation.jeu;

public class Carte {
	//Attributs
	private int valeur = 0;
	private String nom;
	public static int counter = 10;
	
	
	//Accesseurs
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
	
	
	//Constructeurs
	//Constructeur sans paramètres à redéfinir
	// --> même s'il ne fait rien
	public Carte() {
		this("toto");
		System.out.println("COMPTEUR = " + counter++);
	}
	
	//Plusieurs fois le nom de la méthode / constructeur
	//Avec des paramètres différents
	// --> Surcharge
	// --> Polymorphisme ad-hoc
	public Carte(String nom) {
		System.out.println("CREATION D'UNE CARTE ...");
//		if (nom == null) {
//			nom = "toto";
//		}
		this.nom = nom;
	}
	
	//Méthodes
}