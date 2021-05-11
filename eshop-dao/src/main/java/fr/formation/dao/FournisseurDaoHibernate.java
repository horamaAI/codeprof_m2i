package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Fournisseur;

public class FournisseurDaoHibernate extends AbstractDaoHibernate<Fournisseur> implements IFournisseurDao {
	@Override
	public List<Fournisseur> findAll() {
		return this.em
					.createQuery("select f from Fournisseur f", Fournisseur.class)
					.getResultList();
	}

	@Override
	public Optional<Fournisseur> findById(int id) {
		return Optional.ofNullable(
			this.em.find(Fournisseur.class, id)
		);
	}
}