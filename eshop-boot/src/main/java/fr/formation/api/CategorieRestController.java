package fr.formation.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Categorie;
import fr.formation.projection.Views;
import fr.formation.service.CategorieService;

@RestController
@RequestMapping("/api/categorie")
public class CategorieRestController {
	@Autowired
	private CategorieService srvCategorie;
	
	@GetMapping
	@JsonView(Views.Categorie.class)
	public List<Categorie> findAll() {
		return this.srvCategorie.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.CategorieDetailed.class)
	public Categorie findById(@PathVariable int id) {
		return this.srvCategorie.findById(id);
	}
	
	@PostMapping
	@JsonView(Views.CategorieDetailed.class)
	public Categorie add(@Valid @RequestBody Categorie categorie, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		
		return this.srvCategorie.add(categorie);
	}
	
	@PutMapping("/{id}")
	public boolean update(@PathVariable int id, @Valid @RequestBody Categorie categorie, BindingResult result) {
		if (result.hasErrors()) {
			return false;
		}
		
		categorie.setId(id);
		this.srvCategorie.update(categorie);
		return true;
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		this.srvCategorie.deleteById(id);
		return true;
	}
}