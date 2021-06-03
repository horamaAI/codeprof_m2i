package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.formation.service.ProduitService;

@Controller
public class ProduitController {
	@Autowired //Demander à SPRING le ProduitService
	private ProduitService srvProduit;
	
	public void setSrvProduit(ProduitService srvProduit) {
		this.srvProduit = srvProduit;
	}

	public void findById(int id) {
		System.out.println("Appel du service findById ...");
		this.srvProduit.findById(id);
	}
}