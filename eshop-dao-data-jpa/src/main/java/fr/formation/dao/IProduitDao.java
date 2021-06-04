package fr.formation.dao;

import java.util.List;

import fr.formation.model.Categorie;
import fr.formation.model.Produit;

public interface IProduitDao extends IDAO<Produit> {
	public List<Produit> findAllByCategorie(Categorie categorie);
	public List<Produit> findAllByCategorieId(int categorieId);
}