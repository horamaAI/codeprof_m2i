package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Fournisseur;

public class FournisseurDaoSql extends AbstractDaoSql implements IFournisseurDao {
	@Override
	public List<Fournisseur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Fournisseur> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur add(Fournisseur entity) {
		StringBuilder query = new StringBuilder();
		
		query
			.append("INSERT INTO fournisseur")
			.append(" (FOU_NOM, FOU_ADRESSE_MAIL)")
			.append(" VALUES (?, ?)");
		
		this
			.prepare("INSERT INTO fournisseur (FOU_NOM, FOU_ADRESSE_MAIL) VALUES (?, ?)")
			.setParameter(entity.getNom())
			.setParameter("futureadresse@gmail.com")
			.execute();
		
		return entity;
	}

	@Override
	public Fournisseur update(Fournisseur entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}