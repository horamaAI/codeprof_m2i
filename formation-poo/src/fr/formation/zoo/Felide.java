package fr.formation.zoo;

public class Felide extends Mammifere {
	private boolean tache;
	
	public boolean isTache() {
		return tache;
	}

	public void setTache(boolean tache) {
		this.tache = tache;
	}

	//Constructeur
	public Felide() {
//		super(); //Constructeur de la classe mère
		//System.out.println("CREATION D'UN FELIDE ...");
	}
	
	public void dormir() {
		System.out.println("Le félidé dort ...");
	}
	
	public void courrir() {
		System.out.println("Le félidé court ...");
		super.courrir();
	}
}