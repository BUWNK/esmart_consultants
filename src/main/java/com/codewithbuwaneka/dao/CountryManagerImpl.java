package com.codewithbuwaneka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithbuwaneka.dao.CountryManager;
import com.codewithbuwaneka.dao.CountryManagerImpl;
import com.codewithbuwaneka.model.CountrySpecialization;


public class CountryManagerImpl implements CountryManager {
	
	
	private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DbConnector mysql = new MySqlDbConnectorImpl();
		return mysql.getConnection();
	}


	public int CheckCountryName(String country_name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean addCountry(CountrySpecialization countrySpecialization) throws ClassNotFoundException, SQLException {
		
		Connection connection = getconnection();
		
		String query = "INSERT INTO Country_Specialization (country_specialization_id, country_name) VALUES(?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, countrySpecialization.getCountry_specialization_id());
		ps.setString(2, countrySpecialization.getCountry_name());
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}


	public boolean CheckUpdateCountryName(CountrySpecialization countrySpecialization) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
		String query = "UPDATE Country_Specialization SET country_name = ? WHERE country_specialization_id = ?";

		PreparedStatement ps = connection.prepareStatement(query);
		
		
		ps.setString(1, countrySpecialization.getCountry_name());
		ps.setString(2, countrySpecialization.getCountry_specialization_id());
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}

	public boolean deleteCountry(String countryCode) throws ClassNotFoundException, SQLException {
		
		Connection connection = getconnection();
		String query = "DELETE FROM country_specialization WHERE country_specialization_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, countryCode);
		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		
		return result > 0;
	}


	public List<CountrySpecialization> getCountries() throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		String query = "SELECT * FROM country_specialization";
		
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		
		List<CountrySpecialization> countryList = new ArrayList();
		
		while(rs.next()) {
			
			CountrySpecialization country = new CountrySpecialization();

			country.setCountry_specialization_id(rs.getString("country_specialization_id"));
			country.setCountry_name(rs.getString("country_name"));
			
			countryList.add(country);
		}
		
		st.close();
		connection.close();
		
		return countryList;
	}

	
	
	
	
	
}
