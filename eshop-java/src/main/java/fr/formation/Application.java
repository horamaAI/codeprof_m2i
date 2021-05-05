package fr.formation;

import java.util.List;

import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

public class Application {
	public static void main(String[] args) {
		ProduitService service = new ProduitService();
		
		List<Produit> produits = service.findAll();
		
		for (Produit p : produits) {
			System.out.println(p.getId() + " " + p.getLibelle());
		}

//		try {
//			service.findById(50); //�a, �a doit fonctionner
//			service.findById(0); //�a, �a doit �tre impossible
//			service.findById(-10); //�a, �a doit �tre impossible
//		}
//		
//		catch (IdMustBePositiveException idex) {
//			System.out.println("L'identifiant n'est pas strictement > 0 ...");
//		}
	}
}