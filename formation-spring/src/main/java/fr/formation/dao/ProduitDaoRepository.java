package fr.formation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ProduitDaoRepository implements IDAOProduit {
	public void findById(int id) {
		System.out.println("REPO FIND BY ID " + id);
	}
}