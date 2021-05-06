package fr.formation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomPreparedStatement {
	private PreparedStatement statement;
	private int index = 1;
	
	public CustomPreparedStatement(PreparedStatement statement) {
		this.statement = statement;
	}
	
	public CustomPreparedStatement setParameter(int index, Object value) {
		try {
			this.statement.setObject(index, value);
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : remove ..
		}
		
		return this;
	}
	
	public CustomPreparedStatement setParameter(Object value) {
		return this.setParameter(this.index++, value);
	}
	
	public boolean execute() {
		try {
			this.statement.execute();
			return true;
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : remove ..
			return false;
		}
	}
	
	public ResultSet executeQuery() {
		try {
			return this.statement.executeQuery();
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : remove ..
			return null;
		}
	}
}