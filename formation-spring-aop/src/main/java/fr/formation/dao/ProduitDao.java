package fr.formation.dao;

import org.springframework.stereotype.Repository;

import fr.formation.annotation.CustomTransactional;

@Repository
public class ProduitDao {
	@CustomTransactional
	public void findAll() {
		System.out.println("FIND ALL DAO");
	}
}