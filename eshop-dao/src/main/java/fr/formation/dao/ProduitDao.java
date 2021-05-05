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
	
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		
		//Constitution de la liste ...
		
		//Se connecter au SQL
		//Charger le pilote (même si pas obligatoire depuis Java 8)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		
		catch (ClassNotFoundException cnex) {
			System.out.println("Chargement du pilote JDBC impossible ...");
		}
		
		try {
			//Se connecter au serveur
			Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/eshop?serverTimezone=UTC", "root", "");
			
			//Selectionner tous les produits
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM produit");
			
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
	
	
	
	
	public void findById(int id) {
		System.out.println("[bientôt] SELECT * FROM produit WHERE PRO_ID = " + id);
	}
}