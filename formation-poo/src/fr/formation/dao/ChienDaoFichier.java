package fr.formation.dao;

import java.util.List;

import fr.formation.zoo.Chien;

public class ChienDaoFichier implements IChienDAO {
	@Override
	public Chien save(Chien entity) {
		System.out.println("Sauvegarde du chien.");
		return null;
	}

	@Override
	public List<Chien> findAll() {
		System.out.println("Recherche des chiens.");
		return null;
	}

	@Override
	public Chien findById(int id) {
		System.out.println("Recherche du chien " + id);
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		System.out.println("Suppression du chien " + id);
		return false;
	}
}