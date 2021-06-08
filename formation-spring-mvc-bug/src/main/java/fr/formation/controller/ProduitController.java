package fr.formation.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.service.FournisseurService;
import fr.formation.service.ProduitService;

@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private ProduitService srvProduit;
	
	@Autowired
	private FournisseurService srvFournisseur;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("produits", this.srvProduit.findAll());
		
		return "liste-produits";
	}
	
	@GetMapping("/ajouter")
	public String add(Model model) {
		List<Fournisseur> fournisseurs = this.srvFournisseur.findAll();
		
		model.addAttribute("fournisseurs", fournisseurs);
		
		return "form-produit";
	}
	
	@PostMapping("/ajouter")
	public String add(	@RequestParam String libelle,
						@RequestParam BigDecimal prix,
						@RequestParam int stock,
						@RequestParam("fournisseur.id") int fournisseurId) {

		Produit produit = new Produit();
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setId(fournisseurId);
		
		produit.setLibelle(libelle);
		produit.setPrix(prix);
		produit.setStock(stock);
		produit.setFournisseur(fournisseur);
		
		this.srvProduit.add(produit);
		
		return "redirect:.";
	}
	
	@GetMapping("/editer")
	public String edit(@RequestParam int id, Model model) {
		List<Fournisseur> fournisseurs = this.srvFournisseur.findAll();
		
		model.addAttribute("fournisseurs", fournisseurs);
		model.addAttribute("produit", this.srvProduit.findById(id));
		
		return "form-produit";
	}
	
	@PostMapping("/editer")
	public String edit(@RequestParam int id, Produit produit) {
		this.srvProduit.update(produit);
		
		return "redirect:.";
	}
	
	@GetMapping("/supprimer/{id}")
	public String deleteById(@PathVariable int id) {
		this.srvProduit.deleteById(id);
		
		return "redirect:..";
	}
}