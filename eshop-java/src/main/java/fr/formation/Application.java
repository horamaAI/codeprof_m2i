package fr.formation;

import java.util.List;
import java.util.NoSuchElementException;

import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

public class Application {
	public static void main(String[] args) {
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