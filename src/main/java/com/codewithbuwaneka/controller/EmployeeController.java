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
	
		var type = request.getParameter("employeeCode");
		
		if(type != null) {
			
			insertEmployee(request, response);
		}
		else {
			viewEmployee(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var type = request.getParameter("type");
		
		System.out.println("type is " + type);
		
		if(type != null) {
			if(type.equals("add")) {
				insertEmployee(request, response);
				// System.out.println("insert called ");
			}else if (type.equals("update")) {
				updateEmployee(request, response);
			}else if (type.equals("delete")) {
				deleteEmployee(request, response);				
			}
			else {
				viewEmployee(request, response);
			}
			
		}
		
	}
	
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String employee_id  = request.getParameter("employee_id");  
		String full_name = request.getParameter("full_name");
		String nic = request.getParameter("nic"); 
		String user_type = request.getParameter("user_type");  
		String address = request.getParameter("address");  
		String contact_no = request.getParameter("contact_no");  
		String email = request.getParameter("email");
		String password = request.getParameter("password");  
		String dob = request.getParameter("dob");  
		String country_specialization_id = request.getParameter("country_specialization_id"); 
		

		employee emp = new employee(employee_id,full_name,nic,user_type,address,contact_no,email,password,dob,country_specialization_id);
		
		
		try {
			System.out.println(employee_id);
			System.out.println(full_name);
			System.out.println(nic);
			System.out.println(user_type);
			System.out.println(address);
			System.out.println(contact_no);
			System.out.println(email);
			System.out.println(employee_id);
			System.out.println(dob);
			System.out.println(country_specialization_id);
			boolean result = employeeservice.addEmployee(emp);
			if (result) {
				message = "Employee has been successfully added! " + employee_id;
			}
			else {
				message = "Failed to added Employee! " + employee_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-employee.jsp");
		rd.forward(request, response);
			
		
	}
	
	private void updateEmployee (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String employee_id  = request.getParameter("employee_id");  
		String full_name = request.getParameter("full_name");
		String nic = request.getParameter("nic"); 
		String user_type = request.getParameter("user_type");  
		String address = request.getParameter("address");  
		String contact_no = request.getParameter("contact_no");  
		String email = request.getParameter("email");
		String password = request.getParameter("password");  
		String dob = request.getParameter("dob");  
		String country_specialization_id = request.getParameter("country_specialization_id"); 
		
		employee emp = new employee(employee_id,full_name,nic,user_type,address,contact_no,email,password,dob,country_specialization_id);
		
		
		try {
			boolean result = employeeservice.updateEmployee(emp);
			if (result) {
				message = "Employee has been successfully updated! " + employee_id;
			}
			else {
				message = "Failed to updated the employee! " + employee_id;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			System.out.println("error" + e);
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-employee.jsp");
		rd.forward(request, response);
	}
	
	private void deleteEmployee (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String employee_id = request.getParameter("employee_id");
		
		try {

			employee emp = new employee(employee_id);
			
			boolean result = employeeservice.deleteEmployee(emp.getEmployee_id());
			
			if(result) {
				message = "employee has been successfully deleted! Products Name: " + employee_id;
			}else {
				message = "employee delete failed " + employee_id;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
				
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("delete-employee.jsp");
		rd.forward(request, response);
	}
	
	private void viewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("This is called");

    	List<employee> empList = new ArrayList<employee>();

    	    	
		try {
			empList = employeeservice.getEmployees();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			empList = new ArrayList<employee>();
		}
		request.setAttribute("empList", empList);
		
		System.out.println("This is empList" + empList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("view-employee.jsp");		
		rd.forward(request, response);
	}
			

	
}
