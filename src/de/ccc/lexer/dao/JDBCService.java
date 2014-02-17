package de.ccc.lexer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;

import de.ccc.lexer.model.Form;


public class JDBCService {
	Connection connect = null; 
	ResultSet rs = null;  
    PreparedStatement preparedStatement = null;  
    Statement statement = null;
    
    public void insertService(String table, Form form)
    {
    	
    	try {
    		connect = JDBCUtils.getConnection();
			statement = connect.createStatement();
			//INSERT INTO `lexerapp`.`LEX_FORM` (`ADDRESS`, `CONTENT`, `OPDATE`) VALUES ('google.com', '1123', '2014-02-15');
			preparedStatement = connect.prepareStatement
				("insert into  "
						+ "lexerapp."
						+table 
						+"(ADDRESS, CONTENT, OPDATE) values (?, ?, ?)"
				);
			  preparedStatement.setString(1, form.getAddress());
		      preparedStatement.setString(2, form.getContent());
		      preparedStatement.setDate(3, (java.sql.Date) form.getOpdate());
		      preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{
    		JDBCUtils.free(rs, preparedStatement, connect); 
    	}	
    }

	public void selectService() {
		// TODO Auto-generated method stub
		
	}
}
