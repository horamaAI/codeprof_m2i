package fr.formation.service;

import fr.formation.dao.ICategorieDao;
import fr.formation.model.Categorie;

public class CategorieService {
	private ICategorieDao daoCategorie;
	
	public void update() {
		Categorie maCategorie = this.daoCategorie.findById(1);
		
		maCategorie.setLibelle("NOUVEAUX PARACHUTES");
		
		this.daoCategorie.save(maCategorie);
	}
	
	public void findAll() {
		for (Categorie c : this.daoCategorie.findAll()) {
			System.out.println(c.getLibelle());
		}
	}
}