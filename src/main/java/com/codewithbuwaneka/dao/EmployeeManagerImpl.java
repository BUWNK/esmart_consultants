package com.codewithbuwaneka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.employee;


public class EmployeeManagerImpl implements EmployeeManager{

		
	private Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DbConnector mysql = new MySqlDbConnectorImpl();
		return mysql.getConnection();
	}

	public boolean addEmployee(employee employees) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
		String query = "INSERT INTO employee (employee_id, full_name,nic,user_type,address,contact_no,email,password,dob,country_specialization_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, employees.getEmployee_id());
		ps.setString(2, employees.getFull_name());
		ps.setString(3, employees.getNic());
		ps.setString(4, employees.getUser_type());
		ps.setString(5, employees.getAddress());
		ps.setString(6, employees.getContact_no());
		ps.setString(7, employees.getEmail());
		ps.setString(8, employees.getPassword());
		ps.setString(9, employees.getDob());
		ps.setString(10,employees.getCountry_specialization_id());

		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}


	public boolean updateEmployee(employee employees) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
		String query = "UPDATE employee SET full_name = ?, nic = ?, user_type = ?, address = ?, contact_no = ?, email = ?, password = ?, dob = ?, country_specialization_id = ? WHERE employee_id = ?";

		PreparedStatement ps = connection.prepareStatement(query);
		
		
		ps.setString(1, employees.getFull_name());
		ps.setString(2, employees.getNic());
		ps.setString(3, employees.getUser_type());
		ps.setString(4, employees.getAddress());
		ps.setString(5, employees.getContact_no());
		ps.setString(6, employees.getEmail());
		ps.setString(7, employees.getPassword());
		ps.setString(8, employees.getDob());
		ps.setString(9, employees.getCountry_specialization_id());
		ps.setString(10, employees.getEmployee_id());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}

	public boolean deleteEmployee(String employee_id) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		String query = "DELETE FROM employee WHERE employee_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, employee_id);
		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		
		return result > 0;
	}

	public List<employee> getEmployees() throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		String query = "SELECT employee_id,full_name,nic,user_type,address,contact_no,email,dob,country_specialization_id FROM employee";
		
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		
		List<employee> employeeList = new ArrayList();
		
		while(rs.next()) {
			
			employee emp = new employee();
			
			emp.setEmployee_id(rs.getString("employee_id"));
			emp.setFull_name(rs.getString("full_name"));
			emp.setNic(rs.getString("nic"));
			emp.setUser_type(rs.getString("user_type"));
			emp.setAddress(rs.getString("address"));
			emp.setContact_no(rs.getString("contact_no"));
			emp.setEmail(rs.getString("email"));
			emp.setDob(rs.getString("dob"));
			emp.setCountry_specialization_id(rs.getString("country_specialization_id"));
			
			employeeList.add(emp);
		}
		
		st.close();
		connection.close();
		
		return employeeList;
	}
		
}
