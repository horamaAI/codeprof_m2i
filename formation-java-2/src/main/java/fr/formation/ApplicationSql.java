package fr.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplicationSql {
	public static void main(String[] args) {
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
			
			//Afficher le libellé de chaque produit
			while (resultSet.next()) { //Tant qu'on a un résultat
				System.out.println(resultSet.getString("PRO_LIBELLE"));
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println(sqle.getMessage());
		}
	}
}