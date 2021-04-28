package fr.formation;

import fr.formation.soin.ISoigneurChat;
import fr.formation.soin.SoigneurFactory;

public class ApplicationSoigneur {
	public static void main(String[] args) {
		ISoigneurChat soigneurChat = SoigneurFactory.creerSoigneurChat();
		
		soigneurChat.endormir();
	}
}