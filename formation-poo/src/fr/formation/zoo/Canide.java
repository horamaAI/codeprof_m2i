package fr.formation.zoo;

public abstract class Canide extends Mammifere implements IChasseur {
	public void manger() {
		System.out.println("Le canidé mange ...");
	}
	
	@Override
	public void chasser(IChassable proie) {
		System.out.println("Le canidé chasse ... " + proie);
	}
}