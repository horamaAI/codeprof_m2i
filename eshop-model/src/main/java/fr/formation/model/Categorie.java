package fr.formation.model;

public class Categorie {
	private int id;
	private String libelle;
	private String description;
//	private int parentId;
	private Categorie parent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getParent() {
		return parent;
	}

	public void setParent(Categorie parent) {
		this.parent = parent;
	}
}