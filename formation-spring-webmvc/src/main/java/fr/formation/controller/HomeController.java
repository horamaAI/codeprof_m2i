package fr.formation.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.utilisateur.UserSession;

@Controller
@RequestMapping("/demo") //Permet de préfixer toutes les URL de /demo
public class HomeController {
	@Autowired
	private UserSession userSession;
	
	//Tous les arguments reçus sont injectés par SPRING
	@RequestMapping("/home") //On vient mapper /home sur cette méthode
	public String home(HttpSession session, Model model) {
		
		System.out.println(this.userSession.isConnected());
		
		model.addAttribute("utilisateur", "Jérémy");
		
		
//		return "/WEB-INF/home.jsp";
		return "home"; //Le préfix / suffix est configuré dans WebConfig
	}
	
	
	@RequestMapping("/redirect")
	public String redirection(Model model) {
		model.addAttribute("demo", "Albert");
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/home-get", method = RequestMethod.GET)
	public String homeGet(Model model) {
		model.addAttribute("utilisateur", "Jérémy");
		
		
//		return "/WEB-INF/home.jsp";
		return "home"; //Le préfix / suffix est configuré dans WebConfig
	}
	
	@RequestMapping(value = "/home-post", method = RequestMethod.POST)
	public String homePost(Model model) {
		model.addAttribute("utilisateur", "Jérémy");
		
		
//		return "/WEB-INF/home.jsp";
		return "home"; //Le préfix / suffix est configuré dans WebConfig
	}
	
	@GetMapping(value = "/home-get-post")
	public String homeGetPost(Model model) {
		model.addAttribute("utilisateur", "Jérémy");
		
		
//		return "/WEB-INF/home.jsp";
		return "home"; //Le préfix / suffix est configuré dans WebConfig
	}
	
	@PostMapping(value = "/home-get-post")
	public String homeGetPost() {
//		return "/WEB-INF/home.jsp";
		return "home"; //Le préfix / suffix est configuré dans WebConfig
	}
	
	
	
	
	
	
	
	
	

	
	@GetMapping(value = "/home-param")
	public String homeParam(@RequestParam String user, @RequestParam int id, Model model) {
		System.out.println(user);
		
//		int a = Integer.parseInt(id);
		
		model.addAttribute("utilisateur", id);
		
		return "home";
	}


	
	@GetMapping(value = "/home-param-date")
	public String homeParam(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate date, Model model) {
		System.out.println(date);
		
		model.addAttribute("utilisateur", date);
		
		return "home";
	}
	
	
	
	
	


	
	@GetMapping(value = { "/home-pv/{userPV}", "/home-pv/{userPV}/{id}" })
	public String homePathVariable(@PathVariable String userPV, @PathVariable(required = false) Integer id, Model model) {
		System.out.println(userPV);
		System.out.println(id);
		model.addAttribute("utilisateur", userPV);
		
		return "home";
	}

	
	
	
	
	
	
	
}