package fr.formation.service;

import fr.formation.dao.ProduitDao;

public class ProduitService {
	public void findById(int id) {
		ProduitDao dao = new ProduitDao();
		
		dao.findById(id);
	}
}