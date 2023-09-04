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
import javax.servlet.http.HttpSession;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.JobSpecialization;
import com.codewithbuwaneka.model.User;
import com.codewithbuwaneka.service.JobSpecializationService;
import com.codewithbuwaneka.service.UserService;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
	
	private UserService userService;
	
    public LoginController() {
    	userService = UserService.getUserServiceInstance();
    }
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var type = request.getParameter("type");
		
		System.out.println("type is " + type);
		
		if(type != null) {
			
			//insertCountry(request, response);
			System.out.println("not null 31");
		}
		else {
			// insertCountry(request, response);
			login(request, response);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var type = request.getParameter("type");
		
		System.out.println("type is " + type);
		
		if(type != null) {
			if(type.equals("login")) {
				login(request, response);
			}else if (type.equals("register")) {
				register(request, response);
				System.out.println("login called");
			}else if (type.equals("delete")) {
				// deleteCountry(request, response);				
			}
			else {
				login(request, response);
			}
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result = null;
	    String email = request.getParameter("email");		
	    String password = request.getParameter("password");
			
	    System.err.println(email + "____" + email+ " pw: "+password);
	    	
	    try {
	        result = userService.authenticate(email,password);
	        System.out.println("result :"+result);
	    } catch (ClassNotFoundException | SQLException e) {	
	        message = e.getMessage();
	    }
			
	    if (result != null && result.equals("1")) {
	        //response.sendRedirect("admin-dashboard.jsp");
	        response.sendRedirect(request.getContextPath() + "/dashboard");
	        return; // Return here to prevent further processing
	    }
	    
	    request.setAttribute("message", message);
	    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");		
	    rd.forward(request, response);
				
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    String username = request.getParameter("username");		
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");		
	    String usertype = "3";
		
		System.err.println(username + "____" + name + "____" + password + "____" + usertype );
		User user = new User(username,name,password,usertype);
		
		
		try {
			boolean result = userService.register(user);
			if (result) {
				message = "user has been successfully added! " + username;
			}
			else {
				message = "Failed to added user! " + username;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

}
