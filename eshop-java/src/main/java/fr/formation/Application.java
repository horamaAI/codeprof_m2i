package fr.formation;

import java.util.List;
import java.util.NoSuchElementException;

import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Categorie;
import fr.formation.model.Produit;
import fr.formation.service.CategorieService;
import fr.formation.service.ProduitService;

public class Application {
	public static void main(String[] args) {
		daoCategorie();
	}
	
	public static void daoCategorie() {
		CategorieService service = new CategorieService();
		
		for (Categorie c : service.findAll()) {
			System.out.println(c.getId() + " " + c.getLibelle());
		}

		try {
			Categorie maCategorie = service.findById(1);
			
			System.out.println(maCategorie.getId() + " - " + maCategorie.getLibelle());
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
		}
		
		catch (NoSuchElementException nex) {
			System.out.println("Cette catégorie n'existe pas ...");
		}
	}
	
	public static void daoProduit() {
		ProduitService service = new ProduitService();
		
		List<Produit> produits = service.findAll();
		
		for (Produit p : produits) {
			System.out.println(p.getId() + " " + p.getLibelle());
		}

		try {
			Produit monProduit = service.findById(50);
			
			System.out.println(monProduit.getId() + " - " + monProduit.getLibelle());
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
		}
		
		catch (NoSuchElementException nex) {
			System.out.println("Ce produit n'existe pas ...");
		}
	}
}