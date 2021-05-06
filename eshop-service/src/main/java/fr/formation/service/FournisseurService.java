package fr.formation.service;

import fr.formation.dao.DAOFactory;
import fr.formation.dao.IFournisseurDao;
import fr.formation.model.Fournisseur;

public class FournisseurService {
	private IFournisseurDao daoFournisseur = DAOFactory.createFournisseurDao();
	
	public void add(Fournisseur fournisseur) {
		//Eventuellement des v�rifications ici ...
		
		//On demande � la DAO d'ajouter le fournisseur
		this.daoFournisseur.add(fournisseur);
	}
}