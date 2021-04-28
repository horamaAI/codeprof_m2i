package fr.formation.soin;

public class SoigneurChatClinique extends SoigneurClinique implements ISoigneurChat {
	@Override
	public void endormir() {
		System.out.println("Le soigneur chat clinique endort ...");
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