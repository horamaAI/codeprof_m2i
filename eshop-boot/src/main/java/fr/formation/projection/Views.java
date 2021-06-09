package fr.formation.projection;

public interface Views {
	public static interface Common { }
	
	public static interface Produit extends Common { }
	public static interface ProduitDetailed extends Produit { }
	
	public static interface Categorie extends Common { }
	public static interface CategorieDetailed extends Categorie { }
}