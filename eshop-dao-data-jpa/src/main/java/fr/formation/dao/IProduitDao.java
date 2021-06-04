package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Categorie;
import fr.formation.model.Produit;

public interface IProduitDao extends JpaRepository<Produit, Integer> {
	public List<Produit> findAllByCategorie(Categorie categorie);
	public List<Produit> findAllByCategorieId(int categorieId);
}