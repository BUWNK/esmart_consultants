package com.codewithbuwaneka.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.model.employee;

public interface EmployeeManager {
	
	public boolean addEmployee(employee employees) throws ClassNotFoundException, SQLException;

}
