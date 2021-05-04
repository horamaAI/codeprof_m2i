package fr.formation;

import fr.formation.service.ProduitService;

public class Application {
	public static void main(String[] args) {
		ProduitService service = new ProduitService();
		
		service.findById(50);
	}
}