package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IProduitDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Categorie;
import fr.formation.model.Produit;
import fr.formation.projection.ProduitProjection;

@Service //On donne ? SPRING sa gestion
public class ProduitService {
//	private IProduitDao dao = DAOFactory.createProduitDao();
	
	@Autowired //On demande ? SPRING la DAO
	private IProduitDao dao;
	
	public List<Produit> findAll() {
		return this.dao.findAll();
	}
	
	public List<ProduitProjection> findAllProjected() {
		return this.dao.findAllProjected();
	}
	
	public List<Produit> findAllByCategorie(Categorie categorie) {
		return this.dao.findAllByCategorie(categorie);
	}
	
	public Produit findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow(ProduitNotFoundException::new);
	}
	
	public Produit add(Produit produit) {
		//Eventuellement ajouter des v?rifications / validations ici
		
		//On demande ? la DAO de sauvegarder (ajout)
		return this.dao.save(produit);
	}
	
	public void update(Produit produit) {
		//Eventuellement v?rifier si le produit n'est pas null, que l'identifiant existe bien, etc.
		
		//On demande ? la DAO de sauvegarder
		this.dao.save(produit);
	}
	
	public void deleteById(int id) {
		this.dao.deleteById(id);
	}
}