package fr.formation.api;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.service.GooglePlayService;

@RestController
@RequestMapping("/publisher")
public class PublisherRestController {
	@Autowired
	private GooglePlayService srvGooglePlay;
	
	@GetMapping
	public String test() throws GeneralSecurityException, IOException {
		this.srvGooglePlay.createPublisherService();
		
		return "ok";
	}
}