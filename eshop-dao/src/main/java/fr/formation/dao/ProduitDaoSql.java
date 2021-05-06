package fr.formation.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Categorie;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class ProduitDaoSql extends AbstractDaoSql implements IProduitDao {
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		
		try {
			//Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM produit");
			
			//Parcours des r�sultats
			while (resultSet.next()) { //Tant qu'on a un r�sultat
				Produit produit = this.map(resultSet);
				
				//L'ajouter � la liste
				produits.add(produit);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : � retirer avant mise en production ...
		}
		
		//Retourner la liste
		return produits;
	}
	
	public List<Produit> findAllByCategorieId(int categorieId) {
		List<Produit> produits = new ArrayList<>();
		
		try {
			//Selectionner tous les produits qui correspondent � la cat�gorie
			ResultSet resultSet = this
					.prepare("SELECT * FROM produit WHERE PRO_CATEGORIE_ID = ?")
					.setParameter(categorieId)
					.executeQuery();
			
			//Parcours des r�sultats
			while (resultSet.next()) { //Tant qu'on a un r�sultat
				Produit produit = this.map(resultSet);
				
				//L'ajouter � la liste
				produits.add(produit);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : � retirer avant mise en production ...
		}
		
		//Retourner la liste
		return produits;
	}
	
	public List<Produit> findAllByCategorie(Categorie categorie) {
		return this.findAllByCategorieId(categorie.getId());
	}
	
	public Optional<Produit> findById(int id) {
		try {
			//Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM produit WHERE PRO_ID = " + id);
			
			//Parcours du r�sultat
			if (resultSet.next()) { //Si on a un r�sultat
				Produit produit = this.map(resultSet);

				return Optional.of(produit);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : � retirer avant mise en production ...
		}
		
		return Optional.empty();
	}

	@Override
	public Produit add(Produit entity) {
		this
			.prepare("INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_PRIX_ACHAT, PRO_FOURNISSEUR_ID, PRO_CATEGORIE_ID) VALUES (?, ?, ?, ?, ?, ?)")
			.setParameter(entity.getLibelle()) //Libell�
			.setParameter(new BigDecimal(20)) //Prix
			.setParameter(0) //Stock
			.setParameter(new BigDecimal(10)) //Prix d'achat
			.setParameter(entity.getFournisseur().getId()) //ID Fournisseur
			.setParameter(entity.getCategorie().getId()) //ID Cat�gorie
			.execute();
		
		return entity;
	}

	@Override
	public Produit update(Produit entity) {
		StringBuilder query = new StringBuilder();
		
		query
			.append("UPDATE produit SET PRO_LIBELLE = ?,")
			.append(" PRO_PRIX = ?,")
			.append(" PRO_STOCK = ?,")
			.append(" PRO_PRIX_ACHAT = ?,")
			.append(" PRO_FOURNISSEUR_ID = ?,")
			.append(" PRO_CATEGORIE_ID = ?")
			.append(" WHERE PRO_ID = ?");
		
		this
			.prepare(query.toString())
			.setParameter(entity.getLibelle()) //Libell�
			.setParameter(new BigDecimal(20)) //Prix
			.setParameter(0) //Stock
			.setParameter(new BigDecimal(10)) //Prix d'achat
			.setParameter(entity.getFournisseur().getId()) //ID Fournisseur
			.setParameter(entity.getCategorie().getId()) //ID Cat�gorie
			.setParameter(entity.getId()) //ID du produit � modifier
			.execute();
		
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		return this
			.prepare("DELETE FROM produit WHERE PRO_ID = ?")
			.setParameter(id)
			.execute();
	}
	
	private Produit map(ResultSet resultSet) {
		try {
			//R�cup�rer les informations
			int id = resultSet.getInt("PRO_ID");
			String libelle = resultSet.getString("PRO_LIBELLE");
			int categoryId = resultSet.getInt("PRO_CATEGORIE_ID");
			int fournisseurId = resultSet.getInt("PRO_FOURNISSEUR_ID");
			
			//Instancier un produit, une cat�gorie, un fournisseur
			Produit produit = new Produit();
			Categorie categorie = new Categorie();
			Fournisseur fournisseur = new Fournisseur();
			
			//Affecter ses informations
			produit.setId(id);
			produit.setLibelle(libelle);
			produit.setCategorie(categorie);
			produit.setFournisseur(fournisseur);
			
			categorie.setId(categoryId);

			fournisseur.setId(fournisseurId);
			
			//On retourne le produit
			return produit;
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : remove..
			return null;
		}
	}
}