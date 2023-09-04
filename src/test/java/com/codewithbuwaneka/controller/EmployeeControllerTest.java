package com.codewithbuwaneka.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.employee;
import com.codewithbuwaneka.service.Employeeservice;

class EmployeeControllerTest {

	private Employeeservice employeeservice;
	TestInfo testInfo;
	TestReporter testReporter;
	
    public EmployeeControllerTest() {
    	employeeservice = Employeeservice.getEmployeeserviceInstance();
    }
    
    
	@BeforeEach
	void beforeEachMethod(TestInfo testInfo, TestReporter testReporter) {
		//System.out.println("hello");
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	}
	
	
	@Tag("insertEmp")
	@Test
	void insertEmp() {
		
		String employee_id  = "test_employee_id2";  
		String full_name = "test_full_name";
		String nic = "97851422v"; 
		String user_type = "test_user_type";  
		String address = "test_address";  
		String contact_no = "0711234567";  
		String email = "abc@email.com";
		String password = "password@123";  
		String dob = "1997.05.26";  
		String country_specialization_id = "nz"; 
		
		boolean result = false;
		
		String message;
		employee emp = new employee(employee_id,full_name,nic,user_type,address,contact_no,email,password,dob,country_specialization_id);
		
		
		try {
			 result = employeeservice.addEmployee(emp);
			if (result) {
				message = "Employee has been successfully added! " + employee_id;
			}
			else {
				message = "Failed to added Employee! " + employee_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must insert the emp details to the database and return true!");
		String testDescription = "insert the emp details to the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
	}
	
	@Tag("updateEmp")
	@Test
	void updateEmp () {
		
		String employee_id  = "test_employee_id1";  
		String full_name = "test_full_name";
		String nic = "97851422v"; 
		String user_type = "test_user_type";  
		String address = "test_address";  
		String contact_no = "0711234567";  
		String email = "abc@email.com";
		String password = "password@123";  
		String dob = "1997.05.26";  
		String country_specialization_id = "nz"; 
		
		boolean result = false;
		
		String message;
		employee emp = new employee(employee_id,full_name,nic,user_type,address,contact_no,email,password,dob,country_specialization_id);
		try {
			result = employeeservice.updateEmployee(emp);
			if (result) {
				message = "Employee has been successfully updated! " + employee_id;
			}
			else {
				message = "Failed to updated the employee! " + employee_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must update the emp details to the database and return true!");
		String testDescription = "update the emp details to the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
		
		
	}

}
