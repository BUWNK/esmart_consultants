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
import com.codewithbuwaneka.service.CountryService;

public class ContryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String message;
    
	CountryService countryService;
	
    public ContryController() {
    	countryService = CountryService.getCountryServiceInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var type = request.getParameter("countryCode");
			
		if(type != null) {
			
			insertCountry(request, response);
			System.out.println("not null 38");
		}
		else {
			// insertCountry(request, response);
			viewCountries(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var type = request.getParameter("type");
		
		System.out.println("type is " + type);
		
		if(type != null) {
			if(type.equals("add")) {
				insertCountry(request, response);
			}else if (type.equals("update")) {
				updateCountry(request, response);
			}else if (type.equals("delete")) {
				deleteCountry(request, response);				
			}
			else {
				viewCountries(request, response);
			}
		}
	}
	
	
	public void insertCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		String country_id = request.getParameter("countryCode");		
		String country_name = request.getParameter("countryName");
		
		System.err.println(country_id + "____" + country_name);
		CountrySpecialization countrySpecialization = new CountrySpecialization(country_id,country_name);
		
		
		try {
			boolean result = countryService.addCountry(countrySpecialization);
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
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-country.jsp");
		rd.forward(request, response);
	}
	
	private void updateCountry (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country_id = request.getParameter("countryCode");		
		String country_name = request.getParameter("countryName");
	
		CountrySpecialization countrySpecialization = new CountrySpecialization(country_id,country_name);
		
		
		try {
			boolean result = countryService.CheckUpdateCountryName(countrySpecialization);
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
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-country.jsp");
		rd.forward(request, response);
	}
	
	private void deleteCountry (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country_id = request.getParameter("countryCode");
		
		try {

			CountrySpecialization countries = new CountrySpecialization(country_id);
			
			boolean result = countryService.deleteCountry(countries.getCountry_specialization_id());
			
			if(result) {
				message = "Product has been successfully deleted! Products Name: " + country_id;
			}else {
				message = "Failed to delete the product! Products Name: " + country_id;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
				
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("delete-country.jsp");
		rd.forward(request, response);
	}
	
	private void viewCountries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is called");

    	List<CountrySpecialization> countryList = new ArrayList<CountrySpecialization>();

    	    	
		try {
			countryList = countryService.getCountries();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			countryList = new ArrayList<CountrySpecialization>();
		}
		request.setAttribute("countryList", countryList);
		
		System.out.println("This is countryList" + countryList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("view-countries.jsp");		
		rd.forward(request, response);
	}

}
