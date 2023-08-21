package com.codewithbuwaneka.model;

public class JobSpecialization {
	private String job_type_specialization_id;  
	private String job_type_name;
	private String country_specialization_id;  
	private String employee_id;
	
	public JobSpecialization() {
		
	}

	public JobSpecialization(String job_type_specialization_id) {
		this.job_type_specialization_id = job_type_specialization_id;
	}

	public JobSpecialization(String job_type_specialization_id, String job_type_name, String country_specialization_id,
			String employee_id) {
		this.job_type_specialization_id = job_type_specialization_id;
		this.job_type_name = job_type_name;
		this.country_specialization_id = country_specialization_id;
		this.employee_id = employee_id;
	}

	public String getJob_type_specialization_id() {
		return job_type_specialization_id;
	}

	public void setJob_type_specialization_id(String job_type_specialization_id) {
		this.job_type_specialization_id = job_type_specialization_id;
	}

	public String getJob_type_name() {
		return job_type_name;
	}

	public void setJob_type_name(String job_type_name) {
		this.job_type_name = job_type_name;
	}

	public String getCountry_specialization_id() {
		return country_specialization_id;
	}

	public void setCountry_specialization_id(String country_specialization_id) {
		this.country_specialization_id = country_specialization_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	
	
	
	

}
