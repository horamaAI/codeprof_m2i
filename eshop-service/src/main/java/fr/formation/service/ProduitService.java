package fr.formation.service;

import java.util.List;

import fr.formation.dao.ProduitDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Produit;

public class ProduitService {
	public List<Produit> findAll() {
		ProduitDao dao = new ProduitDao();
		
		return dao.findAll();
	}
	
	
	public void findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		ProduitDao dao = new ProduitDao();
		
		dao.findById(id);
	}
}