package fr.formation.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IFournisseurDao;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

@Service
public class FournisseurService {
	@Autowired
	private IFournisseurDao daoFournisseur;
	
	@Transactional
	public void findAll() {
		for (Fournisseur f : this.daoFournisseur.findAll()) {
			System.out.println(f.getNom());
			
			for (Produit p : f.getProduits()) {
				System.out.println(" - " + p.getLibelle());
			}
		}
	}
	
	public void add() {
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setNom("F1");
		fournisseur.setTelephone("06xx");
		fournisseur.setSiret("123456789123");
		fournisseur.setEmail("blabla@gmail.com");
		
		this.daoFournisseur.save(fournisseur);
	}
}