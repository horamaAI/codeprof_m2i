package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Produit;
import fr.formation.service.CategorieService;
import fr.formation.service.FournisseurService;
import fr.formation.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private ProduitService srvProduit;
	
	@Autowired
	private FournisseurService srvFournisseur;

	@Autowired
	private CategorieService srvCategorie;
	
	@GetMapping("/liste")
	public String findAll(Model model) {
		List<Produit> mesProduits = this.srvProduit.findAll();
		
		model.addAttribute("produits", mesProduits);
		
		return "liste-produits";
	}
	
	@GetMapping("/ajouter")
	public String add(Model model) {
		model.addAttribute("fournisseurs", this.srvFournisseur.findAll());
		model.addAttribute("categories", this.srvCategorie.findAll());
		
		return "form-produit";
	}
	
	@PostMapping("/ajouter")
	public String add(Produit produit) {
		this.srvProduit.add(produit);
		
		return "redirect:liste";
	}
	
	
	
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		this.srvProduit.deleteById(id);
		
		return "redirect:liste";
	}
}