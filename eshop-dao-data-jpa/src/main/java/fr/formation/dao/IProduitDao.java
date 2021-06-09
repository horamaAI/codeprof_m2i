package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import fr.formation.model.Categorie;
import fr.formation.model.Produit;
import fr.formation.projection.ProduitProjection;

public interface IProduitDao extends JpaRepository<Produit, Integer> {
	public List<Produit> findAllByCategorie(Categorie categorie);
	
	@RestResource(path = "/find-by-categorie")
	@Query("select p from Produit p where p.categorie.id = :id")
	public List<Produit> findAllByCategorieIid(@Param("id") int categorieId);

	@RestResource(path = "/find-projected")
	@Query("select p from Produit p")
	public List<ProduitProjection> findAllProjected();
}