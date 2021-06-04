package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.annotation.CustomTransactional;
import fr.formation.dao.ProduitDao;

@Service
public class ProduitService {
	@Autowired
	private ProduitDao daoProduit;
	
//	@CustomTransactional
	public void findAll() {
//		System.out.println("Démarrage de la transaction");
		System.out.println("FIND ALL SERVICE");
		this.daoProduit.findAll();
		
//		throw new RuntimeException();
		
//		System.out.println("Fermeture de la transaction");
	}
}