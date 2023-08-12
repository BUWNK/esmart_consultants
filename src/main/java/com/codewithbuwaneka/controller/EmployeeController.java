package com.codewithbuwaneka.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithbuwaneka.model.employee;
import com.codewithbuwaneka.service.Employeeservice;


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
       
	private Employeeservice employeeservice;
	
	
    public EmployeeController() {
    	employeeservice = Employeeservice.getEmployeeserviceInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		var employee_id = request.getParameter("employee_id");
		
		if(employee_id != null) {
			
			insertProduct(request, response);
		}
		else {
			insertProduct(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var employee_id = request.getParameter("employee_id");
		
		if(employee_id != null) {
		insertProduct(request, response);
		}
		
	}

	//
	
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String employee_id = request.getParameter("employee_id");
		
		employee emp = new employee(employee_id);
		
		try {
			boolean result = employeeservice.addEmployee(emp);
			if (result) {
				message = "Employee has been successfully added! " + employee_id;
			}
			else {
				message = "Failed to added employee! " + employee_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-employee.jsp");
		rd.forward(request, response);
		
		
		
	}
	
}
