package fr.formation.soin;

public abstract class SoigneurClinique {
	//Attributs
	//Getters / Setters
	//Constructeurs
	//Méthodes
	
	public SoigneurClinique() {
		this.ouvrirClinique();
	}
	
//	public abstract void ouvrirCliniqueAbstract();
	
	public void ouvrirClinique() {
		System.out.println("Le soigneur ouvre la clinique.");
	}
}