package fr.formation.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomPreparedStatement {
	private PreparedStatement statement;
	
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
	
	public void execute() {
		try {
			this.statement.execute();
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : remove ..
		}
	}
}