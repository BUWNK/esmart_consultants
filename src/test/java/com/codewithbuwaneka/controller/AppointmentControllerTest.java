package com.codewithbuwaneka.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.codewithbuwaneka.model.Appointment;
import com.codewithbuwaneka.model.employee;
import com.codewithbuwaneka.service.AppointmentService;


class AppointmentControllerTest {
	
	TestInfo testInfo;
	TestReporter testReporter;
	private AppointmentService appointmentService;
	
    public AppointmentControllerTest() {
    	appointmentService = AppointmentService.getappointmentInstance();
    }
	
    @BeforeEach
	void beforeEachMethod(TestInfo testInfo, TestReporter testReporter) {
		//System.out.println("hello");
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	}
	
	
	@Tag("insertAppointmnet")
	@Test
	void insertEmp() {
				
		boolean result = false;
		
		
		String appointment_id ="test-apwzzsssssss";
		String job_seeker_username = "test_username";
		String consultant_id = "con002";
		String full_name = "test__name";
		String dob = "1997.08.12";
		String gender = "male";
		String nationality = "sri lankan";
		String passport_no = "451655151561";
		String address = "test_address";
		String phone_no = "0711234567";
		String email = "abc@email.com";
		String education = "degree";
		String uni_name = "icbt";
		String job_title = "se";
		String experience = "3";
		String selectedDestination = "usa";
		String jobcategory = "it";
		String job_role = "it";
		String appointmnet_date = "2023.09.07";
		String appointmnet_time = "9.00";
		
		
		Appointment appointment = new Appointment(appointment_id,consultant_id,job_seeker_username,appointmnet_date,appointmnet_time,full_name,dob,gender,nationality,passport_no,address,phone_no,email,education,uni_name,job_title,experience,selectedDestination,jobcategory,job_role);
		
		
		String message;
		try {
			 result = appointmentService.addAppointmnet(appointment);
			if (result) {
				message = "Appoinmnet has been successfully added! " + appointment_id;
			}
			else {
				message = "Failed to added Appoinmnet! " + appointment_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must insert the appointmnet details to the database and return true!");
		String testDescription = "insert the appointmnet details to the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
	}
	
	@Tag("updateAppointmnet")
	@Test
	void updateEmp() {
		
		boolean result = false;
		
		String appointment_id = "test-apwzzsssss";
		String consultant_id = "testConsultant";
		
		Appointment appointment = new Appointment(appointment_id,consultant_id);
		String message;
		try {
			result = appointmentService.updateAppointmnet(appointment);
			System.out.println("appointment result "+ result);
			if (result) {
				message = "Appoinmnet has been successfully updated! " + appointment_id;
			}
			else {
				message = "Failed to update the Appoinmnet! " + appointment_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must update the appointmnet details to the database and return true!");
		String testDescription = "update the appointmnet details to the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
		
	}

}
