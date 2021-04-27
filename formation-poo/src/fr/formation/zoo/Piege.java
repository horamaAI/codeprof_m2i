package fr.formation.zoo;

public class Piege implements IChassable {
	private static Piege instance = null;
	
	private Piege() { //On verrouille l'instanciation de l'extérieur
		
	}
	
	public static Piege getInstance() {
		if (instance == null) {
			instance = new Piege();
		}
		
		return instance;
	}
}