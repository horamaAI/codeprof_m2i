package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ICategorieDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Categorie;

@Service
public class CategorieService {
	@Autowired
	private ICategorieDao dao;
	
	public List<Categorie> findAll() {
		return this.dao.findAll();
	}
	
	public Categorie findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow();
	}
	
	public Categorie add(Categorie categorie) {
		return this.dao.save(categorie);
	}
	
	public void update(Categorie categorie) {
		this.dao.save(categorie);
	}
	
	public void deleteById(int id) {
		this.dao.deleteById(id);
	}
}