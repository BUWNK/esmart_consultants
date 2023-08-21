package com.codewithbuwaneka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.JobSpecialization;
import com.codewithbuwaneka.service.JobSpecializationService;

public class JobSpecializationManagerImpl implements JobSpecializationManager {

	private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DbConnector mysql = new MySqlDbConnectorImpl();
		return mysql.getConnection();
	}
	
	public boolean addJob(JobSpecialization jobSpecialization) throws ClassNotFoundException, SQLException {
		
		Connection connection = getconnection();
		
		String query = "INSERT INTO job_type_specialization (job_type_specialization_id, job_type_name, country_specialization_id, employee_id) VALUES(?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, jobSpecialization.getJob_type_specialization_id());
		ps.setString(2, jobSpecialization.getJob_type_name());
		ps.setString(3, jobSpecialization.getCountry_specialization_id());
		ps.setString(4, jobSpecialization.getEmployee_id());
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}

	public boolean updateJob(JobSpecialization jobSpecialization) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
		String query = "UPDATE job_type_specialization SET job_type_name = ?, country_specialization_id = ?, employee_id = ? WHERE job_type_specialization_id = ?";

		PreparedStatement ps = connection.prepareStatement(query);
		
		
		ps.setString(1, jobSpecialization.getJob_type_name());
		ps.setString(2, jobSpecialization.getCountry_specialization_id());
		ps.setString(3, jobSpecialization.getEmployee_id());
		ps.setString(4, jobSpecialization.getJob_type_specialization_id());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}

	public boolean deleteJob(String job_type_specialization_id) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		String query = "DELETE FROM job_type_specialization WHERE job_type_specialization_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, job_type_specialization_id);
		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		
		return result > 0;
	}

	public List<JobSpecialization> getJobs() throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		String query = "SELECT * FROM job_type_specialization";
		
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		
		List<JobSpecialization> jobList = new ArrayList();
		
		while(rs.next()) {
			
			JobSpecialization jobs = new JobSpecialization();

			jobs.setJob_type_specialization_id(rs.getString("job_type_specialization_id"));
			jobs.setJob_type_name(rs.getString("job_type_name"));
			jobs.setCountry_specialization_id(rs.getString("country_specialization_id"));
			jobs.setEmployee_id(rs.getString("employee_id"));
			
			jobList.add(jobs);
		}
		
		st.close();
		connection.close();
		
		return jobList;
	}

}
