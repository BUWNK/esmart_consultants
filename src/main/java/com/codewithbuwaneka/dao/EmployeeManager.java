package com.codewithbuwaneka.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.employee;

public interface EmployeeManager {
	
	public boolean addEmployee(employee employees) throws ClassNotFoundException, SQLException;
	public boolean updateEmployee(employee employees) throws ClassNotFoundException, SQLException;
	public boolean deleteEmployee(String employee_id) throws ClassNotFoundException, SQLException;
	public List<employee> getEmployees() throws ClassNotFoundException, SQLException;	

}
