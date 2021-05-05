package fr.formation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDaoSql {
	protected Connection connection;
	
	public AbstractDaoSql() {
		this.createConnection();
	}
	
	public void createConnection() {
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
			System.out.println("Impossible d'exécuter la requête.");
			
			return null;
		}
	}
}