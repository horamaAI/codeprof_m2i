package fr.formation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Produit;

public class ProduitDao {
	private Connection connection;
	
	public ProduitDao() {
		this.createConnection();
	}
	
	public void createConnection() {
		//Charger le pilote (m�me si pas obligatoire depuis Java 8)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		
		catch (ClassNotFoundException cnex) {
			System.out.println("Chargement du pilote JDBC impossible ...");
		}
		
		try {
			System.out.println("CONNEXION !!");
			//Se connecter au serveur
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?serverTimezone=UTC", "root", "");
		}
		
		catch (SQLException sqle) {
			System.out.println("Impossible de se connecter.");
		}
	}
	
	public ResultSet getResult(String query) {
		try {
			Statement statement = this.connection.createStatement();
			
			return statement.executeQuery(query);
		}
		
		catch (Exception sqle) {
			System.out.println("Impossible d'ex�cuter la requ�te.");
			
			return null;
		}
	}
	
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
	
	public Produit findById(int id) {
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

				return produit;
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : � retirer avant mise en production ...
		}
		
		return null;
	}
}