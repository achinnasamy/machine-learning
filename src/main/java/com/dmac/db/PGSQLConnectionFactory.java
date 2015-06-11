package com.dmac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PGSQLConnectionFactory {

	
	private static PGSQLConnectionFactory instance = new PGSQLConnectionFactory();
	
	
	private PGSQLConnectionFactory() {} 
	
	
	public static PGSQLConnectionFactory getInstance() {
		return instance;
	}
	
	/**
	 * 
	 * HStore
	 * 
	 * CREATE EXTENSION hstore;
	 
	 
	   CREATE TABLE ponn (name_of_warrior varchar, attributes hstore);
	 
	 insert into ponn (name_of_warrior, attributes) values ('chola', 'state=>south_india,king=>raja_raja_chola,city=>madurai');
	 
	 select * from ponn where attributes->'state'='south_india';
	 
	 select name_of_warrior,hstore_to_json(attributes) from ponn where attributes->'state'='south_india';
	 
	 * 
	 */
	public void connect() {
		 
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karthika", "postgres", "root");
			Statement statement = connect.createStatement();
			ResultSet rs  = statement.executeQuery("select name_of_warrior,hstore_to_json(attributes) from ponn where attributes->'state'='south_india'");
			
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
         
	}
}
