package fr.formation.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Produit;

public class ProduitDaoSql extends AbstractDaoSql implements IProduitDao {
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		
		try {
			//Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM produit");
			
			//Parcours des résultats
			while (resultSet.next()) { //Tant qu'on a un résultat
				//Récupérer les informations
				int id = resultSet.getInt("PRO_ID");
				String libelle = resultSet.getString("PRO_LIBELLE");
				
				//Instancier un produit
				Produit produit = new Produit();
				
				//Affecter ses informations
				produit.setId(id);
				produit.setLibelle(libelle);
				
				//L'ajouter à la liste
				produits.add(produit);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : à retirer avant mise en production ...
		}
		
		//Retourner la liste
		return produits;
	}
	
	public Optional<Produit> findById(int id) {
		try {
			//Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM produit WHERE PRO_ID = " + id);
			
			//Parcours du résultat
			if (resultSet.next()) { //Si on a un résultat
				//Récupérer les informations
				String libelle = resultSet.getString("PRO_LIBELLE");
				
				//Instancier le produit
				Produit produit = new Produit();
				
				//Affecter ses informations
				produit.setId(id);
				produit.setLibelle(libelle);

				return Optional.of(produit);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : à retirer avant mise en production ...
		}
		
		return Optional.empty();
	}

	@Override
	public Produit add(Produit entity) {
		this
			.prepare("INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_PRIX_ACHAT, PRO_FOURNISSEUR_ID, PRO_CATEGORIE_ID) VALUES (?, ?, ?, ?, ?, ?)")
			.setParameter(1, entity.getLibelle())
			.setParameter(2, new BigDecimal(20))
			.setParameter(3, 0)
			.setParameter(4, new BigDecimal(10))
			.setParameter(5, 1)
			.setParameter(6, 1)
			.execute();
		
		return entity;
	}

	@Override
	public Produit update(Produit entity) {
		// TODO UPDATE
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO DELETE
		return false;
	}
}