package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Categorie;
import fr.formation.model.Produit;

public interface IProduitDao extends JpaRepository<Produit, Integer> {
	public List<Produit> findAllByCategorie(Categorie categorie);
	
	@Query("select p from Produit p where p.categorie.id = ?1")
	public List<Produit> findAllByCategorieIid(int categorieId);
}