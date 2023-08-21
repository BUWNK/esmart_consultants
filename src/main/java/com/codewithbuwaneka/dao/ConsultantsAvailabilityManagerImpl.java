package com.codewithbuwaneka.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithbuwaneka.model.ConsultantsAvailability;
import com.codewithbuwaneka.model.CountrySpecialization;

public class ConsultantsAvailabilityManagerImpl implements ConsultantsAvailabilityManager {

	private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DbConnector mysql = new MySqlDbConnectorImpl();
		return mysql.getConnection();
	}
	
	public List<ConsultantsAvailability> getConsultantsAvailability() throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		String query = "SELECT c.consultant_id, e.full_name AS employee_full_name, e.contact_no AS employee_contact_no, e.email AS employee_email, cs.country_name, jts.job_type_name, c.availability FROM consultants c JOIN    employee e ON c.employee_id = e.employee_id LEFT JOIN country_specialization cs ON c.country_specialization_id = cs.country_specialization_id LEFT JOIN job_type_specialization jts ON    c.job_type_specialization_id = jts.job_type_specialization_id;";
		
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		
		List<ConsultantsAvailability> consultantsAvailabilityList = new ArrayList();
		
		while(rs.next()) {
			
			ConsultantsAvailability consultantsAvailability = new ConsultantsAvailability();

			// country.setCountry_specialization_id(rs.getString("country_specialization_id"));
			// country.setCountry_name(rs.getString("country_name"));
			consultantsAvailability.setConsultant_id(rs.getString("consultant_id"));
			consultantsAvailability.setFull_name(rs.getString("employee_full_name"));
			consultantsAvailability.setContact_no(rs.getString("employee_contact_no"));
			consultantsAvailability.setEmail(rs.getString("employee_email"));
			consultantsAvailability.setCountry_specialization(rs.getString("country_name"));
			consultantsAvailability.setJob_type_specialization(rs.getString("job_type_name"));
			consultantsAvailability.setAvailability(rs.getString("availability"));
			
			consultantsAvailabilityList.add(consultantsAvailability);
		}
		
		st.close();
		connection.close();
		
		return consultantsAvailabilityList;
	}

}
