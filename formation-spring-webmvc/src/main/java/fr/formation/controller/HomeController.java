package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home") //On vient mapper /home sur cette méthode
	public String home() {
		return "/WEB-INF/home.jsp";
	}
}