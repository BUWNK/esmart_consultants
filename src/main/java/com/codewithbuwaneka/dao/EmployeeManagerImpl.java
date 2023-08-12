package com.codewithbuwaneka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithbuwaneka.model.employee;


public class EmployeeManagerImpl implements EmployeeManager{

	/*
	 * 1. Import the package
	 * 2. Load the driver
	 * 3. Establish the connection
	 * 4. Create the statement
	 * 5. Execute the query
	 * 6. Process the result
	 * 7. Close the connection and the statement  
	 */
		
	private Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DbConnector mysql = new MySqlDbConnectorImpl();
		return mysql.getConnection();
	}

	public boolean addEmployee(employee employees) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
		String query = "INSERT INTO employee (employee_id) VALUES(?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, employees.getEmployee_id());

		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}
		
}
