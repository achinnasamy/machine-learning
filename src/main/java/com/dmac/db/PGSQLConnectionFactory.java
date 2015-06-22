package com.dmac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.dmac.vector.GroupzDataVector;

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
			PreparedStatement ps = connect.prepareStatement("select name_of_warrior,hstore_to_json(attributes) from ponn where attributes->'state'='south_india'");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
         
	}
	
	
	/**
	 * CREATE TABLE groupz_data (licence_key varchar(20), 
	 							 machineID varchar(20),
	 							 memberID varchar(20),
	 							 timeFormat varchar(20),
	 							 timeZone varchar(20),	 
	 							 extended_data hstore);
	 * 
	 * @param gdv
	 */
	public void persistGroupzDataVector(GroupzDataVector gdv) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "2");
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karthika", "postgres", "root");
			PreparedStatement ps = connect.prepareStatement("insert into groupz_data values(?,?,?,?,?,?)");
			ps.setString(1, gdv.getLicenceKey());
			ps.setString(2, gdv.getMachineID());
			ps.setString(3, gdv.getMemberID());
			ps.setString(4, gdv.getTimeFormat());
			ps.setString(5, gdv.getTimeZone());
			
			ps.setObject(6, convertToDatabaseColumn(map), 1111);
			
			ps.executeUpdate();	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	private String convertToDatabaseColumn(final Map<String, String> attribute) {
        final StringBuilder builder = new StringBuilder();
        for (final Map.Entry<String, String> entry : attribute.entrySet()) {
            if(builder.length() > 1) {
                builder.append(", ");
            }
            builder.append("\"");
            builder.append(entry.getKey());
            builder.append("\"");
            builder.append("=>");
            builder.append("\"");
            builder.append(entry.getValue().toString());
            builder.append("\"");
        }
        return builder.toString();
    }
	public Optional<GroupzDataVector> persistGroupzDataVector() {
		
		Optional<GroupzDataVector> gdv = Optional.empty();
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karthika", "postgres", "root");
			PreparedStatement ps = connect.prepareStatement("select name_of_warrior,hstore_to_json(attributes) from ponn where attributes->'state'='south_india'");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return gdv;
	}
}
