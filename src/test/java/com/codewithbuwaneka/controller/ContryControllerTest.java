package com.codewithbuwaneka.controller;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.SQLException;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.service.AppointmentService;
import com.codewithbuwaneka.service.CountryService;



class ContryControllerTest {

	public CountryService countryService;
	
	TestInfo testInfo;
	TestReporter testReporter;
	
	public ContryControllerTest() {
		countryService = CountryService.getCountryServiceInstance();
		
	}
	
	@BeforeEach
	void beforeEachMethod(TestInfo testInfo, TestReporter testReporter) {
		//System.out.println("hello");
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	}
	
	@Tag("insertCountry")
	@Test
	void insertCountry() {
		String country_id = "testCode11";		
		String country_name = "testCountryName7";
		boolean result = false;
		CountrySpecialization countrySpecialization = new CountrySpecialization(country_id,country_name);
		
		
		String message;
		try {
			result = countryService.addCountry(countrySpecialization);
			if (result) {
				message = "Country has been successfully added! " + country_id;
				System.out.println(result);
			}
			else {
				message = "Failed to added country! " + country_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must insert the country name and code to the database and return true!");
		String testDescription = "insert the country name and code to the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
	}
	
	@Tag("updateCountry")
	@Test
	void updateCountry () {
		String country_id = "testCode7";		
		String country_name = "countryName8";
	
		CountrySpecialization countrySpecialization = new CountrySpecialization(country_id,country_name);		
		boolean result = false;
		String message;
		try {
			 result = countryService.CheckUpdateCountryName(countrySpecialization);
			if (result) {
				message = "Country has been successfully added! " + country_id;
			}
			else {
				message = "Failed to added country! " + country_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		

		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must update the country name and code to the database and return true!");
		String testDescription = "update the country name acording to the code in the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
	}
	
		
	
}
