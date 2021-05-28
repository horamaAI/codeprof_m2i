package fr.formation.service;

import java.util.List;

import fr.formation.dao.DAOFactory;
import fr.formation.dao.IFournisseurDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Fournisseur;

public class FournisseurService {
	private IFournisseurDao daoFournisseur = DAOFactory.createFournisseurDao();
	
	public List<Fournisseur> findAll() {
		return this.daoFournisseur.findAll();
	}

	public Fournisseur findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.daoFournisseur.findById(id).orElseThrow();
	}
	
	public void add(Fournisseur fournisseur) {
		//Eventuellement des vérifications ici ...
		
		//On demande à la DAO d'ajouter le fournisseur
		this.daoFournisseur.add(fournisseur);
	}
	
	public void deleteById(int id) {
		this.daoFournisseur.deleteById(id);
	}
}