package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping({ "", "/accueil" })
	public String home(Model model) {
		model.addAttribute("username", "Jérémy");
		
		return "home";
	}
}