package fr.formation;

import java.util.List;

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
			Produit monProduit = service.findById(0); //ça, ça doit fonctionner
			
			System.out.println(monProduit.getId() + " - " + monProduit.getLibelle());
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
		}
	}
}