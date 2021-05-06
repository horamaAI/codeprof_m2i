package fr.formation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDaoSql {
	protected static Connection connection;
	
	public AbstractDaoSql() {
		this.createConnection();
	}
	
	public void createConnection() {
		if (connection == null) {
			//Charger le pilote (même si pas obligatoire depuis Java 8)
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			
			catch (ClassNotFoundException cnex) {
				System.out.println("Chargement du pilote JDBC impossible ...");
			}
			
			try {
				System.out.println("CONNEXION !!");
				//Se connecter au serveur
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?serverTimezone=UTC", "root", "");
			}
			
			catch (SQLException sqle) {
				System.out.println("Impossible de se connecter.");
			}
		}
	}
	
	public ResultSet getResult(String query) {
		try {
			Statement statement = connection.createStatement();
			
			return statement.executeQuery(query);
		}
		
		catch (Exception sqle) {
			System.out.println("Impossible d'exécuter la requête.");
			
			return null;
		}
	}
	
	public CustomPreparedStatement prepare(String query) {
		try {
			return new CustomPreparedStatement(connection.prepareStatement(query));
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : remove ...
			
			return null;
		}
	}
}