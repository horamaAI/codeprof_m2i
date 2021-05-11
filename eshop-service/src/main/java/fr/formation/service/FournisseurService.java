package fr.formation.service;

import fr.formation.dao.DAOFactory;
import fr.formation.dao.IFournisseurDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Fournisseur;

public class FournisseurService {
	private IFournisseurDao daoFournisseur = DAOFactory.createFournisseurDao();

	public Fournisseur findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.daoFournisseur.findById(id).orElseThrow();
	}
	
	public void add(Fournisseur fournisseur) {
		//Eventuellement des v�rifications ici ...
		
		//On demande � la DAO d'ajouter le fournisseur
		this.daoFournisseur.add(fournisseur);
	}
}