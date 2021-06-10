package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.service.CategorieService;

@Controller
public class CategorieController {
	@Autowired
	private CategorieService srvCategorie;
	
	@GetMapping("/categorie/liste")
	public String findAll(Model model) {
		model.addAttribute("categories", this.srvCategorie.findAll());
		
		return "liste-categories";
	}
}