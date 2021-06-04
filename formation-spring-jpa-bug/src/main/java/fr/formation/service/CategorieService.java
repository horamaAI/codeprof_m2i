package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ICategorieDao;
import fr.formation.model.Categorie;

@Service
public class CategorieService {
	@Autowired
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