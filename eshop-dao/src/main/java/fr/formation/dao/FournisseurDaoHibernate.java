package fr.formation.dao;

import fr.formation.model.Fournisseur;

public class FournisseurDaoHibernate extends AbstractDaoHibernate<Fournisseur> implements IFournisseurDao {
	public FournisseurDaoHibernate() {
		super(Fournisseur.class);
	}
}