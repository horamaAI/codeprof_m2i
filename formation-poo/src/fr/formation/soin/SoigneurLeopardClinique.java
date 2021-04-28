package fr.formation.soin;

import fr.formation.zoo.Leopard;

public class SoigneurLeopardClinique extends SoigneurClinique implements ISoigneurLeopard {
	@Override
	public void endormir(Leopard animal) {
		System.out.println("Le soigneur léopard clinique endort ...");
	}

	@Override
	public void soigner() {
		System.out.println("Le soigneur léopard clinique soigne ...");
	}

	@Override
	public void reveiller() {
		System.out.println("Le soigneur léopard clinique réveille ...");
	}

	@Override
	public void rechercher() {
		System.out.println("Le soigneur léopard clinique recherche ...");
	}
}