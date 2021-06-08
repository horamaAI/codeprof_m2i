package fr.formation.api;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Produit;

@RestController
public class ProduitRestController {
	@GetMapping("/api/produit/demo")
	public Produit demo() {
		return new Produit();
	}
	
	@PostMapping("/api/produit/demo")
	//@RequestBody demande à SPRING de traduire le flux reçu, avec un convertisseur (Jackson par exemple)
	public boolean add(@Valid @RequestBody Produit produit, BindingResult result) {
		System.out.println(produit.getLibelle());
		System.out.println(produit.getFournisseur().getId());
		
		if (result.hasErrors()) {
			return false;
		}
		
		return true;
	}
}