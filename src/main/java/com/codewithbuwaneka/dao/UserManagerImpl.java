package com.codewithbuwaneka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.User;
import com.mysql.cj.exceptions.RSAException;

public class UserManagerImpl implements UserManager {

	private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DbConnector mysql = new MySqlDbConnectorImpl();
		return mysql.getConnection();
	}

	
	public String authenticate(String username, String password) throws ClassNotFoundException, SQLException {
		
	    String userType = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
		Connection connection = getconnection();
		
		try {
			
			String query = "SELECT usertype FROM user WHERE username = ? AND password = ? ";
			
			ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
	        if (rs.next()) {
	            userType = rs.getString("usertype");
	        }
	        
	        System.out.println("user type: "+userType);
	        
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ps.close();
			rs.close();
			connection.close();			
		}
		
		return userType;
	}



	public boolean register(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
		String query = "INSERT INTO user (username, name, password,usertype) VALUES(?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getUsertype());
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}

}
