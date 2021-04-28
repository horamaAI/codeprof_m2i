package fr.formation.dao;

import java.util.List;

import fr.formation.zoo.Loup;

public class LoupDaoFichier implements ILoupDAO {
	@Override
	public Loup save(Loup entity) {
		System.out.println("Sauvegarde du loup.");
		return null;
	}

	@Override
	public List<Loup> findAll() {
		System.out.println("Recherche des loups.");
		return null;
	}

	@Override
	public Loup findById(int id) {
		System.out.println("Recherche du loup " + id);
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		System.out.println("Suppression du loup " + id);
		return false;
	}
}