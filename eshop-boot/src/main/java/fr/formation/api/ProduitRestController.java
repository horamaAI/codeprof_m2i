package fr.formation.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.exception.ProduitNotValidException;
import fr.formation.model.Produit;
import fr.formation.projection.Views;
import fr.formation.service.ProduitService;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin("*") //Permet de dire qu'on accepte les requ?tes de tous les domaines (*)
public class ProduitRestController {
	@Autowired
	private ProduitService srvProduit;
	
	@GetMapping
	@JsonView(Views.Produit.class)
	public List<Produit> findAll() {
		return this.srvProduit.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ProduitDetailed.class)
	public Produit findById(@PathVariable int id) {
		return this.srvProduit.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.ProduitDetailed.class)
	public Produit add(@Valid @RequestBody Produit produit, BindingResult result) {
		if (result.hasErrors()) {
			throw new ProduitNotValidException();
		}
		
		return this.srvProduit.add(produit);
	}
	
	@PutMapping("/{id}")
	public boolean update(@PathVariable int id, @Valid @RequestBody Produit produit, BindingResult result) {
		if (result.hasErrors()) {
			return false;
		}
		
		produit.setId(id); //Pour ?tre s?r de faire un update au lieu d'un insert
		this.srvProduit.update(produit);
		return true;
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		this.srvProduit.deleteById(id);
		return true;
	}
	
	
	
	
	// ------------------------------------------------------
	
	@GetMapping(value = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Produit demo() {
		return new Produit();
	}
	
	@PostMapping("/demo")
	//@RequestBody demande ? SPRING de traduire le flux re?u, avec un convertisseur (Jackson par exemple)
	public boolean demoAdd(@Valid @RequestBody Produit produit, BindingResult result) {
		System.out.println(produit.getLibelle());
		System.out.println(produit.getFournisseur().getId());
		
		if (result.hasErrors()) {
			return false;
		}
		
		return true;
	}
	
	@GetMapping("/demo/status")
	@ResponseStatus(code = HttpStatus.CREATED, reason = "OK !")
	public boolean demoStatus() {
		return true;
	}
	
	@GetMapping("/demo/status2")
	public ResponseEntity<Boolean> demoStatus2() {
		if (true) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}