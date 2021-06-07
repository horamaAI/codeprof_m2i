package fr.formation.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Produit;

@Controller
public class ProduitController {
	@GetMapping("/produit/ajouter")
	public String add() {
		return "form-produit";
	}

//	@PostMapping("/produit/ajouter")
//	public String add(@RequestParam String libelle, @RequestParam BigDecimal prix) {
//		Produit monProduit = new Produit();
//		
//		monProduit.setLibelle(libelle);
//		monProduit.setPrix(prix);
//		
//		System.out.println(monProduit.getLibelle());
//		System.out.println(monProduit.getPrix());
//		
//		return "form-produit";
//	}
	
	@PostMapping("/produit/ajouter")
	public String add(Produit monProduit, @RequestParam String autre, @RequestParam(required = false) String autre2) {
		System.out.println(monProduit.getLibelle());
		System.out.println(monProduit.getPrix());
		System.out.println(monProduit.getFournisseur().getId());
		System.out.println(monProduit.getFournisseur().getNom());
		System.out.println(autre);
		System.out.println(autre2);
		
		return "form-produit";
	}
	
	@GetMapping("/produit/bind") // /produit/bind?libelle=Test&prix=12&fournisseur.id=42
	public String add(Produit monProduit) {
		System.out.println(monProduit.getLibelle());
		System.out.println(monProduit.getPrix());
		System.out.println(monProduit.getFournisseur().getId());
		
		return "form-produit";
	}
}