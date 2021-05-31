package fr.formation.service;

import java.util.List;

import fr.formation.dao.DAOFactory;
import fr.formation.dao.ICategorieDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Categorie;

public class CategorieService {
	private ICategorieDao dao = DAOFactory.createCategoryDao();
	
	public List<Categorie> findAll() {
		return this.dao.findAll();
	}
	
	public Categorie findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow();
	}
	
	public void add(Categorie categorie) {
		this.dao.add(categorie);
	}
	
	public void update(Categorie categorie) {
		this.dao.update(categorie);
	}
	
	public void deleteById(int id) {
		this.dao.deleteById(id);
	}
}