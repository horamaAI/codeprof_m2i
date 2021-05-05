package fr.formation.service;

import java.util.List;

import fr.formation.dao.ProduitDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Produit;

public class ProduitService {
	private ProduitDao dao = new ProduitDao();
	
	public List<Produit> findAll() {
		return this.dao.findAll();
	}
	
	
	public Produit findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id);
	}
}