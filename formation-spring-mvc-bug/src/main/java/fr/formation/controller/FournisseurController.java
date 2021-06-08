package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Fournisseur;
import fr.formation.service.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
	@Autowired
	private FournisseurService srvFournisseur;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("fournisseurs", this.srvFournisseur.findAll());
		
		return "liste-fournisseurs";
	}
	
	@GetMapping("/ajouter")
	public String add() {
		return "form-fournisseur";
	}
	
	@PostMapping("/ajouter")
	public String add(Fournisseur fournisseur) {
		this.srvFournisseur.add(fournisseur);
		
		// /fournisseur/ajouter -> /fournisseur
		// /fournisseur/ajouter -> ./ -> /fournisseur/. -> /fournisseur/
		// /fournisseur/ajouter -> /fournisseur -> /fournisseur
		// /fournisseur/ajouter -> ./modifier -> /fournisseur/./modifier -> /fournisseur/modifier
		return "redirect:.";
	}
	
	@GetMapping("/modifier")
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("fournisseur", this.srvFournisseur.findById(id));
		
		return "form-fournisseur";
	}
	
	@PostMapping("/modifier")
	public String edit(Fournisseur fournisseur) {
		try {
			this.srvFournisseur.update(fournisseur);
		}
		
		catch (Exception e) {
			return "form-fournisseur";
		}
		
		return "redirect:.";
	}
	
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		this.srvFournisseur.deleteById(id);
		
		return "redirect:.";
	}
}