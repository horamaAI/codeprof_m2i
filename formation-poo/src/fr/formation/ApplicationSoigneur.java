package fr.formation;

import fr.formation.soin.ISoigneurChat;
import fr.formation.soin.SoigneurFactory;
import fr.formation.zoo.Chat;
import fr.formation.zoo.Cheval;
import fr.formation.zoo.Leopard;

public class ApplicationSoigneur {
	public static void main(String[] args) {
		ISoigneurChat soigneurChat = SoigneurFactory.creerSoigneurChat();
		
		soigneurChat.endormir(new Chat());
	}
}