package fr.formation.dao;

import java.sql.PreparedStatement;
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
	
	public void execute() {
		try {
			this.statement.execute();
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : remove ..
		}
	}
}