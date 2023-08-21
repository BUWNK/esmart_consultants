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

import com.codewithbuwaneka.model.ConsultantsAvailability;
import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.service.ConsultantsAvailabilityService;
import com.codewithbuwaneka.service.CountryService;

public class ConsultantsAvailabilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private String message;
    
	private ConsultantsAvailabilityService consultantsAvailabilityService;
	    
    public ConsultantsAvailabilityController() {
    	consultantsAvailabilityService = ConsultantsAvailabilityService.getConsultantsAvailabilityInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var type = request.getParameter("consultant_id");
		
		if(type != null) {
			
			// insertCountry(request, response);
			System.out.println("not null 38");
		}
		else {
			// insertCountry(request, response);
			viewConsultantsAvailability(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void viewConsultantsAvailability(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is called");

    	List<ConsultantsAvailability> consultantsAvailabilityList = new ArrayList<ConsultantsAvailability>();

    	    	
		try {
			consultantsAvailabilityList = consultantsAvailabilityService.getConsultantsAvailability();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println(message);
			consultantsAvailabilityList = new ArrayList<ConsultantsAvailability>();
		}
		request.setAttribute("consultantsAvailabilityList", consultantsAvailabilityList);
		
		System.out.println("This is consultantsAvailabilityList" + consultantsAvailabilityList);
		
		System.out.println("This is consultantsAvailabilityList:");
		
		for (ConsultantsAvailability availability : consultantsAvailabilityList) {
		    System.out.println("ConsultantsAvailability --- "+ availability);
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("view-ConsultantsAvailability.jsp");		
		rd.forward(request, response);
	}
}
