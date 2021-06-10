package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ICategorieDao;
import fr.formation.model.Categorie;

@Service
public class CategorieService {
	@Autowired
	private ICategorieDao daoCategorie;
	
	public List<Categorie> findAll() {
		return this.daoCategorie.findAll();
	}
}