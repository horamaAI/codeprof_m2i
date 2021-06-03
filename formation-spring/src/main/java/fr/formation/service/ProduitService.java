package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IDAOProduit;

@Service
public class ProduitService {
	@Autowired
	private IDAOProduit daoProduit;
	
	public void findById(int id) {
		System.out.println("Appel du repo produit findById ... ");
		this.daoProduit.findById(id);
	}
}