package com.codewithbuwaneka.service;

import java.sql.SQLException;

import com.codewithbuwaneka.dao.EmployeeFactory;
import com.codewithbuwaneka.dao.EmployeeManager;
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
		
		
		EmployeeManager employeeManager = EmployeeFactory.getEmployeeManager();
		
		return employeeManager.addEmployee(employees);
	}
}

