package fr.formation.soin;

import fr.formation.zoo.Chat;

public class SoigneurChatZoo implements ISoigneurChat {
	@Override
	public void endormir(Chat animal) {
		System.out.println("Le soigneur chat zoo endort ...");
	}

	@Override
	public void soigner() {
		System.out.println("Le soigneur chat zoo soigne ...");
	}

	@Override
	public void reveiller() {
		System.out.println("Le soigneur chat zoo réveille ...");
	}
}