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
	
	public void add(Produit produit) {
		//Eventuellement ajouter des vérifications / validations ici
		
		//On demande à la DAO de sauvegarder (ajout)
		this.dao.add(produit);
	}
	
	public void update(Produit produit) {
		//Eventuellement vérifier si le produit n'est pas null, que l'identifiant existe bien, etc.
		
		//On demande à la DAO de sauvegarder
		this.dao.update(produit);
	}
	
	public void deleteById(int id) {
		this.dao.deleteById(id);
	}
}