package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IFournisseurDao;
import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Fournisseur;

@Service
public class FournisseurService {
	@Autowired
	private IFournisseurDao daoFournisseur;
	
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
		this.daoFournisseur.save(fournisseur);
	}
	
	public void update(Fournisseur fournisseur) {
		//Eventuellement des vérifications ici ...
		
		//On demande à la DAO de modifier le fournisseur
		this.daoFournisseur.save(fournisseur);
	}
	
	public void deleteById(int id) {
		this.daoFournisseur.deleteById(id);
	}
}