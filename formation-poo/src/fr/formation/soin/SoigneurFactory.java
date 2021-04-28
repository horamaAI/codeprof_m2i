package fr.formation.soin;

public class SoigneurFactory {
	public static ISoigneurChat creerSoigneurChat() {
		return new SoigneurChatClinique();
	}
	
	public static ISoigneurLeopard creerSoigneurLeopard() {
		return new SoigneurLeopardClinique();
	}
}