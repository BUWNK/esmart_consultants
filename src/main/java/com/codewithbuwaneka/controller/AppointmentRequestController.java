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

import com.codewithbuwaneka.model.Appointment;
import com.codewithbuwaneka.model.AppointmentRequest;
import com.codewithbuwaneka.service.AppointmentRequestService;
import com.codewithbuwaneka.service.AppointmentService;


public class AppointmentRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String message;
    
	private AppointmentRequestService appointmentRequestService;
	
    public AppointmentRequestController() {
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

		doGet(request, response);
		
		var type = request.getParameter("type");
		
		System.out.println("type is " + type);
		
		if(type != null) {
			if(type.equals("approve")) {
				approveAppointment(request, response);
			}else if (type.equals("update")) {
				// updateAppointment(request, response);
				// System.out.println("assign called");
			}else if (type.equals("delete")) {
				// deleteCountry(request, response);				
			}
			else {
				// viewCountries(request, response);
			}
		}
		
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
		RequestDispatcher rd = request.getRequestDispatcher("view-appointment.jsp");
		
		rd.forward(request, response);
	}
	
	private void approveAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is called - approveAppointment");
		String appointment_id = request.getParameter("appointment_id");
		String status = request.getParameter("approve");
		
		System.out.println("appointment_id - "+appointment_id);
		System.out.println("status - "+status);
		
		
		AppointmentRequest appointmentRequest = new AppointmentRequest(appointment_id,status);
		
		
		try {
			boolean result = appointmentRequestService.updateAppointmnetRequest(appointmentRequest);
			System.out.println("appointment result "+ result);
			if (result) {
				message = "Appoinmnet has been successfully approved! " + appointment_id;
			}
			else {
				message = "Failed to approved Appoinmnet! " + appointment_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
				
//		request.setAttribute("message", message);
//		RequestDispatcher rd = request.getRequestDispatcher("assign-appontmnet.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect(request.getContextPath() + "/approval");
		
	}

}
