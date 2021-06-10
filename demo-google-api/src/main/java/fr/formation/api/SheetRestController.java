package fr.formation.api;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.service.GoogleSheetService;

@RestController
@RequestMapping("/sheet")
public class SheetRestController {
	@Autowired
	private GoogleSheetService srvGoogleSheet;
	
	@GetMapping
	public String test() throws GeneralSecurityException, IOException {
		this.srvGoogleSheet.createSheetService();
		this.srvGoogleSheet.read();
		
		return "ok";
	}
}