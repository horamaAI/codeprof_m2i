package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.utilisateur.UserSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserSession userSession;
	
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public String login(HttpSession session,
						@RequestParam String username,
						@RequestParam String password,
						Model model) {
		
		if (username.equals("toto") && password.equals("titi")) {
			session.setAttribute("sessionUser", username);
			
			this.userSession.setConnected(true);
			this.userSession.setUsername(username);
			
			return "redirect:/demo/home";
		}
		
		model.addAttribute("erreur", "Nom d'utilisateur ou mot de passe incorrect.");
		return "login";
	}
}