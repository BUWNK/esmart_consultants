package com.codewithbuwaneka.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.dao.CountryManager;
import com.codewithbuwaneka.dao.CountryManagerImpl;
import com.codewithbuwaneka.dao.EmployeeManager;
import com.codewithbuwaneka.dao.EmployeeManagerImpl;
import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.employee;


public class Employeeservice {

	private static Employeeservice employeeserviceObj;
	
	private Employeeservice() {
		
	}
	
	public static synchronized Employeeservice getEmployeeserviceInstance() {
		
		if(employeeserviceObj == null) {
			employeeserviceObj = new Employeeservice();
		}
		
		return employeeserviceObj;
	}
	
	//-----------------------------services	
	
	public static boolean addEmployee(employee employees) throws ClassNotFoundException, SQLException {
		
        EmployeeManager employeeManager = new EmployeeManagerImpl();
        return employeeManager.addEmployee(employees);
	}
	
	public static boolean updateEmployee(employee employees) throws ClassNotFoundException, SQLException {
		
        EmployeeManager employeeManager = new EmployeeManagerImpl();
        return employeeManager.updateEmployee(employees);
	}
	
	public static boolean deleteEmployee(String employee_id) throws ClassNotFoundException, SQLException {
		
        EmployeeManager employeeManager = new EmployeeManagerImpl();
        return employeeManager.deleteEmployee(employee_id);
	}
	
	public List<employee> getEmployees() throws ClassNotFoundException, SQLException {
		
		EmployeeManager employeeManager = new EmployeeManagerImpl();
		return employeeManager.getEmployees();
	}
}

