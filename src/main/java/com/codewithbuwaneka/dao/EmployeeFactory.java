package com.codewithbuwaneka.dao;

public class EmployeeFactory {
	
	public static EmployeeManager getEmployeeManager() {
		
		return new EmployeeManagerImpl();
	}
}
