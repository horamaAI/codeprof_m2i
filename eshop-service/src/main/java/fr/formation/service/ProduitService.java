package fr.formation.service;

import java.util.List;

import fr.formation.dao.DAOFactory;
import fr.formation.dao.IProduitDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Categorie;
import fr.formation.model.Produit;

public class ProduitService {
	private IProduitDao dao = DAOFactory.createProduitDao();
	
	public List<Produit> findAll() {
		return this.dao.findAll();
	}
	
	public List<Produit> findAllByCategorie(Categorie categorie) {
		return this.dao.findAllByCategorie(categorie);
	}
	
	
	public Produit findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow();
	}
}