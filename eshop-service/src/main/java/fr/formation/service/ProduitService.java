package fr.formation.service;

import fr.formation.dao.ProduitDao;
import fr.formation.exception.IdMustBePositiveException;

public class ProduitService {
	public void findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		ProduitDao dao = new ProduitDao();
		
		dao.findById(id);
	}
}