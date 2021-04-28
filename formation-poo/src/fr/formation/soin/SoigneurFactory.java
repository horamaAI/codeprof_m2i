package fr.formation.soin;

public class SoigneurFactory {
	public static ISoigneurChat creerSoigneurChat() {
		return new SoigneurChatZoo();
	}
	
	public static ISoigneurLeopard creerSoigneurLeopard() {
		return new SoigneurLeopardClinique();
	}
}