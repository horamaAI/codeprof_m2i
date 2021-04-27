package fr.formation.zoo;

public class AnimalFactory {
	public static Felide creerFelide() {
		return new Chat();
	}
	
	public static Canide creerCanide() {
		return new Loup();
	}
	
	public static Animal creerAnimal(String type) {
		type = type.toLowerCase(); //on met tout en minuscule
		
		//Solution #1
		switch (type) {
			case "chat": return new Chat();
			case "chien": return new Chien();
			default: return null;
		}
		
		//Solution #2
//		if (type.equals("chat")) {
//			return new Chat();
//		}
//		
//		else if (type.equals("chien")) {
//			return new Chien();
//		}
//		
//		return null;
		
		//Solution #3 : Possible à faire en utilisant la Réflexivité (avancé)
	}
}