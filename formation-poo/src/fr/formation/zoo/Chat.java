package fr.formation.zoo;

public class Chat extends Felide {
	//Constructeur
	public Chat() {
		System.out.println("CREATION D'UN CHAT ...");
		
		this.setCouleur(CouleurAnimal.BLEUE);
	}
	
	public void dormir() {
		System.out.println("Le chat dort ...");
		super.dormir();
	}
	
	public void griffer() {
		System.out.println("Le chat griffe ...");
	}
	
	@Override
	public String toString() {
		return "ToString du Chat";
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}

	@Override
	public void manger() {
		System.out.println("Le chat mange ...");
	}

	@Override
	public void chasser(IChassable proie) {
		System.out.println("Le chat chasse ... " + proie);
	}
}