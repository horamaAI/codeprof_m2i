package fr.formation;

import fr.formation.controller.ProduitController;

public class ApplicationSansSpring {
	public static void main(String[] args) {
		ProduitController ctrlProduit = DemoSansSpringFactory.controller();
		
		ctrlProduit.findById(1);
	}
}