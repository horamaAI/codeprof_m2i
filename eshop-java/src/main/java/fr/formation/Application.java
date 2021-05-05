package fr.formation;

import fr.formation.exception.IdMustBePositiveException;
import fr.formation.service.ProduitService;

public class Application {
	public static void main(String[] args) {
		ProduitService service = new ProduitService();

		try {
			service.findById(50); //ça, ça doit fonctionner
			service.findById(0); //ça, ça doit être impossible
			service.findById(-10); //ça, ça doit être impossible
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
		}
	}
}