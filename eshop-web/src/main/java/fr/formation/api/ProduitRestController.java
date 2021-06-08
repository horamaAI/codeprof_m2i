package fr.formation.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Produit;
import fr.formation.projection.Views;
import fr.formation.service.ProduitService;

@RestController
public class ProduitRestController {
	@Autowired
	private ProduitService srvProduit;
	
	@GetMapping("/api/produit")
	@JsonView(Views.Produit.class)
	public List<Produit> findAll() {
		return this.srvProduit.findAll();
	}
	
	@GetMapping(value = "/api/produit/demo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Produit demo() {
		return new Produit();
	}
	
	@PostMapping("/api/produit/demo")
	//@RequestBody demande � SPRING de traduire le flux re�u, avec un convertisseur (Jackson par exemple)
	public boolean add(@Valid @RequestBody Produit produit, BindingResult result) {
		System.out.println(produit.getLibelle());
		System.out.println(produit.getFournisseur().getId());
		
		if (result.hasErrors()) {
			return false;
		}
		
		return true;
	}
}