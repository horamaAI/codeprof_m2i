package fr.formation.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
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
			
			//Parcours des r�sultats
			while (resultSet.next()) { //Tant qu'on a un r�sultat
				//R�cup�rer les informations
				int id = resultSet.getInt("PRO_ID");
				String libelle = resultSet.getString("PRO_LIBELLE");
				
				//Instancier un produit
				Produit produit = new Produit();
				
				//Affecter ses informations
				produit.setId(id);
				produit.setLibelle(libelle);
				
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
	
	public Optional<Produit> findById(int id) {
		try {
			//Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM produit WHERE PRO_ID = " + id);
			
			//Parcours du r�sultat
			if (resultSet.next()) { //Si on a un r�sultat
				//R�cup�rer les informations
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
			sqle.printStackTrace(); //TODO : � retirer avant mise en production ...
		}
		
		return Optional.empty();
	}

	@Override
	public Produit add(Produit entity) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_PRIX_ACHAT, PRO_FOURNISSEUR_ID, PRO_CATEGORIE_ID) VALUES (?, ?, ?, ?, ?, ?)");
			
			preparedStatement.setString(1, entity.getLibelle());
			preparedStatement.setBigDecimal(2, new BigDecimal(20));
			preparedStatement.setInt(3, 0);
			preparedStatement.setBigDecimal(4, new BigDecimal(10));
			preparedStatement.setInt(5, 1);
			preparedStatement.setInt(6, 1);
			
			//ON EXECUTE LA REQUETE
			preparedStatement.executeUpdate();
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO to remove ...
		}
		
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