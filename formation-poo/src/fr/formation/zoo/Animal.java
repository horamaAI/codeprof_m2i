package fr.formation.zoo;

public abstract class Animal implements IChassable {
	private int age;
	private int taille;
	private String nom;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public abstract void manger();
	
	public void dormir() {
		System.out.println("L'animal dort ...");
	}
}