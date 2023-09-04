package com.codewithbuwaneka.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import com.codewithbuwaneka.service.UserService;

class LoginControllerTest {
	
	private UserService userService;
	TestInfo testInfo;
	TestReporter testReporter;
	
    public LoginControllerTest() {
    	userService = UserService.getUserServiceInstance();
    }

    @BeforeEach
	void beforeEachMethod(TestInfo testInfo, TestReporter testReporter) {
		//System.out.println("hello");
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	}
    
	@Tag("login")
	@Test
	void testLogin() {
		
		String result = null;
		String email = "a";
		String password = "a";
		
		System.err.println(email + "____" + email+ " pw: "+password);
    	
		try {
			
			result = userService.authenticate(email,password);
			System.out.println("result :"+result);
		} catch (ClassNotFoundException | SQLException e) {	
			
			String message = e.getMessage();
			System.out.println(message);
		}
		
		String expected = "1";
		String actual = result;
		assertEquals(expected, actual, "this must return the login user type from the database !");
		String testDescription = "return the login user type fromthe database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
		
	}

}
