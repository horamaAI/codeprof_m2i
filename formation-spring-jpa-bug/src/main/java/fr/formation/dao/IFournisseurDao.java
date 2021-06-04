package fr.formation.dao;

import java.util.List;

import fr.formation.model.Fournisseur;

public interface IFournisseurDao extends IDao<Fournisseur> {
	public int count();
	public List<Fournisseur> findAllFetchingProduits();
}