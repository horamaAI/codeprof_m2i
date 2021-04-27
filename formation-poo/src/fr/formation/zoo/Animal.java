package fr.formation.zoo;

public class Animal {
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
	
	
	public void manger() {
		System.out.println("L'animal mange ...");
	}
	
	public void dormir() {
		System.out.println("L'animal dort ...");
	}
}