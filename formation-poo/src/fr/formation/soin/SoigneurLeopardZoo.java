package fr.formation.soin;

public class SoigneurLeopardZoo implements ISoigneurLeopard {
	@Override
	public void endormir() {
		System.out.println("Le soigneur léopard zoo endort ...");
	}

	@Override
	public void soigner() {
		System.out.println("Le soigneur léopard zoo soigne ...");
	}

	@Override
	public void reveiller() {
		System.out.println("Le soigneur léopard zoo réveille ...");
	}

	@Override
	public void rechercher() {
		System.out.println("Le soigneur léopard zoo recherche ...");
	}
}