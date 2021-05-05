package fr.formation;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
			//INSERT
			String produitLibelle = "FROM JAVA (v1)";
			String produitLibellev2 = "FROM JAVA (v2)";
			BigDecimal produitPrix = new BigDecimal(100);
			int produitStock = 4;
			BigDecimal produitPrixAchat = new BigDecimal(50);
			int produitFournisseurId = 1;
			int produitCategorieId = 1;
			
			//Version "classique", la concaténation de chaine (!!! attention injection sql ... !!!)
			statement.execute("INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_PRIX_ACHAT, PRO_FOURNISSEUR_ID, PRO_CATEGORIE_ID) " + 
					"	VALUES ('" + produitLibelle + "', " + produitPrix + ", " + produitStock + ", " + produitPrixAchat + ", " + produitFournisseurId + ", " + produitCategorieId + ")");
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_PRIX_ACHAT, PRO_FOURNISSEUR_ID, PRO_CATEGORIE_ID) VALUES (?, ?, ?, ?, ?, ?)");
			
			if (true) {
				preparedStatement.setString(1, produitLibellev2);
			}
			
			else {
				preparedStatement.setString(1, produitLibelle);
			}
			
			preparedStatement.setBigDecimal(2, produitPrix);
			preparedStatement.setInt(3, produitStock);
			preparedStatement.setBigDecimal(4, produitPrixAchat);
			preparedStatement.setInt(5, produitFournisseurId);
			preparedStatement.setInt(6, produitCategorieId);
			
			//ON EXECUTE LA REQUETE
			int rows = preparedStatement.executeUpdate();
			System.out.println(rows + " lignes enregistrées.");
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println(sqle.getMessage());
		}
	}
}