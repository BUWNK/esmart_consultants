package com.codewithbuwaneka.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithbuwaneka.model.Appointment;
import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.service.AppointmentService;
import com.codewithbuwaneka.service.CountryService;
import com.codewithbuwaneka.service.MailSender;

public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String message;
    
	private AppointmentService appointmentService;
	
    public AppointmentController() {
    	appointmentService = AppointmentService.getappointmentInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var type = request.getParameter("countryCode");
		
		if(type != null) {
			
			//insertCountry(request, response);
			System.out.println("not null 38");
		}
		else {
			// insertCountry(request, response);
			assignAppointmnet(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		var type = request.getParameter("type");
				
		System.out.println("type is " + type);
		
		if(type != null) {
			if(type.equals("add")) {
				insertAppoinmnet(request, response);
			}else if (type.equals("update")) {
				updateAppointment(request, response);
				System.out.println("assign called");
			}else if (type.equals("delete")) {
				// deleteCountry(request, response);				
			}
			else {
				// viewCountries(request, response);
			}
		}
	}

	public void insertAppoinmnet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String appointment_id = RandomStringGenerator();
		String job_seeker_username = getJobSeekerUserNamet();
		String consultant_id = selectConsultant();
		System.out.println("consultant_id - "+consultant_id);
		String full_name = request.getParameter("full_name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String nationality = request.getParameter("nationality");
		String passport_no = request.getParameter("passport_no");
		String address = request.getParameter("address");
		String phone_no = request.getParameter("phone_no");
		String email = request.getParameter("email");
		String education = request.getParameter("education");
		String uni_name = request.getParameter("uni_name");
		String job_title = request.getParameter("job_title");
		String experience = request.getParameter("experience");
		String selectedDestination = request.getParameter("selectedDestination");
		String jobcategory = request.getParameter("jobcategory");
		String job_role = request.getParameter("job_role");
		String appointmnet_date = request.getParameter("appointmnet_date");
		String appointmnet_time = request.getParameter("appointmnet_time");
		
		
		Appointment appointment = new Appointment(appointment_id,consultant_id,job_seeker_username,appointmnet_date,appointmnet_time,full_name,dob,gender,nationality,passport_no,address,phone_no,email,education,uni_name,job_title,experience,selectedDestination,jobcategory,job_role);
		
		
		try {
			boolean result = appointmentService.addAppointmnet(appointment);
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
		

		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("make-appointment.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void assignAppointmnet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is called");

    	List<Appointment> assignAppointmnetList = new ArrayList<Appointment>();

    	    	
		try {
			assignAppointmnetList = appointmentService.assignAppointmnet();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			assignAppointmnetList = new ArrayList<Appointment>();
		}
		request.setAttribute("assignAppointmnetList", assignAppointmnetList);
		
		System.out.println("This is countryList" + assignAppointmnetList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("assign-appontmnet.jsp");		
		rd.forward(request, response);
		
		// response.sendRedirect(request.getContextPath() + "/appointment");
		

		
	}
	
	public void updateAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is called - updateAppointment");
		String appointment_id = request.getParameter("appointment_id");
		String consultant_id = request.getParameter("assignConsultant");
		
		System.out.println("appointment_id - "+appointment_id);
		System.out.println("consultant_id - "+consultant_id);
		
		
		Appointment appointment = new Appointment(appointment_id,consultant_id);
		
		System.out.println("appointment object "+ appointment);
		
		try {
			boolean result = appointmentService.updateAppointmnet(appointment);
			System.out.println("appointment result "+ result);
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
				
//		request.setAttribute("message", message);
//		RequestDispatcher rd = request.getRequestDispatcher("assign-appontmnet.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect(request.getContextPath() + "/appointment");
		
	}
	
	private String RandomStringGenerator() {
		
        int length = 6;
        String prefix = "ap";
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder(prefix);

        Random random = new Random();
        for (int i = 0; i < length - prefix.length(); i++) {
            int randomIndex = random.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }
        System.out.println(randomString.toString());

        return randomString.toString();
		
		
	}
	
	private String selectConsultant() {
		
        String consultant_id = "con001";
        return consultant_id.toString();
	}
	
	private String getJobSeekerUserNamet() {
		
        String job_seeker_username = "uthpala";
        return job_seeker_username.toString();
	}
}
