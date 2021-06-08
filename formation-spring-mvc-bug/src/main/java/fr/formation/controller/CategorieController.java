package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Categorie;
import fr.formation.service.CategorieService;

@Controller
public class CategorieController {
	@Autowired
	private CategorieService srvCategorie;
	
	@GetMapping("/categorie")
	public String findAll(Model model) {
		model.addAttribute("categories", this.srvCategorie.findAll());
		
		return "liste-categories";
	}
	
	@GetMapping("/categorie/ajouter")
	public String add() {
		return "form-categorie";
	}
	
	@PostMapping("/categorie/ajouter")
	public String add(Categorie categorie) {
		this.srvCategorie.add(categorie);
		
		return "redirect:.";
	}
	
	@GetMapping("/modifier")
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("categorie", this.srvCategorie.findById(id));
		
		return "form-catgorie";
	}
	
	@PostMapping("/modifier")
	public String edit(Categorie categorie) {
		try {
			this.srvCategorie.update(categorie);
		}
		
		catch (Exception e) {
			return "form-categorie";
		}
		
		return "redirect:.";
	}
	
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		this.srvCategorie.deleteById(id);
		
		return "redirect:.";
	}
}