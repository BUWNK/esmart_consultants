package com.codewithbuwaneka.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.JobSpecialization;
import com.codewithbuwaneka.service.CountryService;
import com.codewithbuwaneka.service.JobSpecializationService;


public class JobSpecializationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String message;
    
	private JobSpecializationService jobSpecializationService;
	
    public JobSpecializationController() {
    	jobSpecializationService = JobSpecializationService.getjobSpecializationInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var type = request.getParameter("job_type_specialization_id");
			
		if(type != null) {		
			insertJobs(request, response);
		}
		else {
			viewJobs(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var type = request.getParameter("type");
		
		System.out.println("type is " + type);
		
		if(type != null) {
			if(type.equals("add")) {
				insertJobs(request, response);
			}else if (type.equals("update")) {
				updateJobs(request, response);
			}else if (type.equals("delete")) {
				deleteJobs(request, response);				
			}
			else {
				viewJobs(request, response);
			}			
		}		
	}
	
	
	public void insertJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		String job_type_specialization_id = request.getParameter("job_type_specialization_id");		
		String job_type_name = request.getParameter("job_type_name");
		String country_specialization_id = request.getParameter("country_specialization_id");
		String employee_id = request.getParameter("employee_id");
		
		// CountrySpecialization countrySpecialization = new CountrySpecialization(country_id,country_name);
		JobSpecialization jobSpecialization = new JobSpecialization(job_type_specialization_id, job_type_name, country_specialization_id, employee_id);
		
		try {
			boolean result = jobSpecializationService.addJob(jobSpecialization);
			if (result) {
				message = "Country has been successfully added! " + job_type_specialization_id;
			}
			else {
				message = "Failed to added country! " + job_type_specialization_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-job.jsp");
		rd.forward(request, response);
	}
	
	
	public void updateJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String job_type_specialization_id = request.getParameter("job_type_specialization_id");		
		String job_type_name = request.getParameter("job_type_name");
		String country_specialization_id = request.getParameter("country_specialization_id");
		String employee_id = request.getParameter("employee_id");
		
		// CountrySpecialization countrySpecialization = new CountrySpecialization(country_id,country_name);
		JobSpecialization jobSpecialization = new JobSpecialization(job_type_specialization_id, job_type_name, country_specialization_id, employee_id);
		
		try {
			boolean result = jobSpecializationService.updateJob(jobSpecialization);
			if (result) {
				message = "Country has been successfully added! " + job_type_specialization_id;
			}
			else {
				message = "Failed to added country! " + job_type_specialization_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-job.jsp");
		rd.forward(request, response);
	}
	
	public void deleteJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String job_type_specialization_id = request.getParameter("job_type_specialization_id");
		
		try {

			JobSpecialization jobSpecialization = new JobSpecialization(job_type_specialization_id);
			
			boolean result = jobSpecializationService.deleteJob(jobSpecialization.getJob_type_specialization_id());
			if(result) {
				message = "Product has been successfully deleted! Products Name: " + job_type_specialization_id;
			}else {
				message = "Failed to delete the product! Products Name: " + job_type_specialization_id;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
				
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("delete-job.jsp");
		rd.forward(request, response);
	}
	
	private void viewJobs (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is called");

    	List<JobSpecialization> jobList = new ArrayList<JobSpecialization>();

    	    	
		try {
			jobList = jobSpecializationService.getJobs();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			jobList = new ArrayList<JobSpecialization>();
		}
		request.setAttribute("jobList", jobList);
		
		System.out.println("This is countryList" + jobList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("view-jobs.jsp");		
		rd.forward(request, response);
	}

}
