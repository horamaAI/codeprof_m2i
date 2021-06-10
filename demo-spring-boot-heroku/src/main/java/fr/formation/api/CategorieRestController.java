package fr.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.ICategorieDao;
import fr.formation.model.Categorie;

@RestController
@RequestMapping("/api/categorie")
public class CategorieRestController {
	@Autowired
	private ICategorieDao daoCategorie;
	
	@GetMapping
	public List<Categorie> findAll() {
		return this.daoCategorie.findAll();
	}
}