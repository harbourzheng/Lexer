package de.ccc.lexer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	public static String url ="jdbc:mysql://localhost/lexerapp?"
            + "user=lexerapp&password=test";
	 static {  
	        try {  
	            Class.forName("com.mysql.jdbc.Driver");  
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        }  
	    }
	 public static Connection getConnection()
	 {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return connect;
	 }
	 
	 public static void free(ResultSet rs,Statement st,Connection con){  
	        if(rs!=null){  
	            try {  
	                rs.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if(st!=null){  
	            try {  
	                st.close();  
	            } catch (SQLException e) {   
	                e.printStackTrace();  
	            }  
	        }  
	        if(con!=null){  
	            try {  
	                con.close();  
	            } catch (SQLException e) {    
	                e.printStackTrace();  
	            }  
	        }  
	 }
}
