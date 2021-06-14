package fr.formation.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/page-login")
	public String login() {
		return "login";
	}
}