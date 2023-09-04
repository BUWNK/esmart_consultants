package com.codewithbuwaneka.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import com.codewithbuwaneka.model.JobSpecialization;
import com.codewithbuwaneka.service.JobSpecializationService;

class JobSpecializationControllerTest {

	TestInfo testInfo;
	TestReporter testReporter;
	private JobSpecializationService jobSpecializationService;
	
    public JobSpecializationControllerTest() {
    	jobSpecializationService = JobSpecializationService.getjobSpecializationInstance();
    }
    
	@BeforeEach
	void beforeEachMethod(TestInfo testInfo, TestReporter testReporter) {
		//System.out.println("hello");
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	}
	
	// insertJobs
	
	@Tag("insertJobs")
	@Test
	void testInsertJobs() {
		
		String job_type_specialization_id = "tst3";		
		String job_type_name = "test_job";
		String country_specialization_id = "usa";
		String employee_id = "emp03";
		
		boolean result = false;		
		String message;
		
		JobSpecialization jobSpecialization = new JobSpecialization(job_type_specialization_id, job_type_name, country_specialization_id, employee_id);
		
		try {
			 result = jobSpecializationService.addJob(jobSpecialization);
			if (result) {
				message = "Job has been successfully added! " + job_type_specialization_id;
			}
			else {
				message = "Failed to added Job! " + job_type_specialization_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must insert the job details to the database and return true!");
		String testDescription = "insert the job details to the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
		
	}
	
	@Tag("updateJobs")
	@Test
	void testUpdateJobs() {
		
		String job_type_specialization_id = "tst";		
		String job_type_name = "test_job_updated_2";
		String country_specialization_id = "usa";
		String employee_id = "emp03";
		
		boolean result = false;		
		String message;
		
		JobSpecialization jobSpecialization = new JobSpecialization(job_type_specialization_id, job_type_name, country_specialization_id, employee_id);
		
		try {
			 result = jobSpecializationService.updateJob(jobSpecialization);
			if (result) {
				message = "Job has been successfully updated! " + job_type_specialization_id;
			}
			else {
				message = "Failed to updated Job! " + job_type_specialization_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must update the job details to the database and return true!");
		String testDescription = "update the job details to the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
		
	}
	
	@Tag("deleteJobs")
	@Test
	void testDeleteJobs() {
		
		String job_type_specialization_id = "tst3";
		
		boolean result = false;		
		String message;
		
		try {

			JobSpecialization jobSpecialization = new JobSpecialization(job_type_specialization_id);
			
			 result = jobSpecializationService.deleteJob(jobSpecialization.getJob_type_specialization_id());
			if(result) {
				message = "Product has been successfully deleted! Products Name: " + job_type_specialization_id;
			}else {
				message = "Failed to delete the product! Products Name: " + job_type_specialization_id;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		
		boolean expected = result;
		boolean actual = true;
		assertEquals(expected, actual, "this must delete the job details to the database and return true!");
		String testDescription = "delete the job details to the database" + "Actual value should return is: " + actual +" ,returned value is: "+ expected ;
		testReporter.publishEntry(testDescription);
		
		
	}

}
