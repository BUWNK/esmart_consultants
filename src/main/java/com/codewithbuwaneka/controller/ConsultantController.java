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

import com.codewithbuwaneka.model.AppointmentRequest;
import com.codewithbuwaneka.model.ConsultantsAvailability;
import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.service.AppointmentRequestService;
import com.codewithbuwaneka.service.ConsultantsAvailabilityService;
import com.codewithbuwaneka.service.CountryService;


public class ConsultantController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String message;
    
	private AppointmentRequestService appointmentRequestService;

    public ConsultantController() {
    	appointmentRequestService = AppointmentRequestService.getAppointmentRequestInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var type = request.getParameter("appointment_id");
		
		if(type != null) {
			
			//insertCountry(request, response);
			System.out.println("line no: 32");
		}
		else {
			// insertCountry(request, response);
			viewAppointmnet(request, response);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void viewAppointmnet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is called");

    	List<AppointmentRequest> appointmentRequesttList = new ArrayList<AppointmentRequest>();

    	    	
		try {
			appointmentRequesttList = appointmentRequestService.viewAppointmnet();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			appointmentRequesttList = new ArrayList<AppointmentRequest>();
		}
		request.setAttribute("appointmentRequesttList", appointmentRequesttList);
		
		System.out.println("This is Appointmnet" + appointmentRequesttList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("consultant-dashboard.jsp");
		
		rd.forward(request, response);
	}
}
