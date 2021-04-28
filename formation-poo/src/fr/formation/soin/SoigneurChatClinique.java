package fr.formation.soin;

import java.util.ArrayList;

import fr.formation.zoo.Animal;
import fr.formation.zoo.Chat;

public class SoigneurChatClinique extends SoigneurClinique implements ISoigneurChat {
	@Override
	public void endormir(Chat animal) {
		System.out.println("Le soigneur chat clinique endort ... " + animal);
	}

	@Override
	public void soigner() {
		System.out.println("Le soigneur chat clinique soigne ...");
	}

	@Override
	public void reveiller() {
		System.out.println("Le soigneur chat clinique réveille ...");
	}
}