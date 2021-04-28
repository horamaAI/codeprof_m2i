package fr.formation.soin;

import fr.formation.zoo.Animal;

public interface ISoigneur<T extends Animal> {
	public void endormir(T animal);
	public void soigner();
	public void reveiller();
}