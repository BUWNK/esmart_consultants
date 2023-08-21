package com.codewithbuwaneka.model;

public class ConsultantsAvailability {
	
	private String consultant_id;  
	private String full_name;
	private String contact_no;
	private String email;
	private String country_specialization; 
	private String job_type_specialization;  
	private String availability;
	
	
	public ConsultantsAvailability() {}

	public ConsultantsAvailability(String consultant_id) {

		this.consultant_id = consultant_id;
	}

	public ConsultantsAvailability(String consultant_id, String full_name, String contact_no,
			String email, String country_specialization, String job_type_specialization, String availability) {
		this.consultant_id = consultant_id;
		this.full_name = full_name;
		this.contact_no = contact_no;
		this.email = email;
		this.country_specialization = country_specialization;
		this.job_type_specialization = job_type_specialization;
		this.availability = availability;
	}

	public String getConsultant_id() {
		return consultant_id;
	}

	public void setConsultant_id(String consultant_id) {
		this.consultant_id = consultant_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry_specialization() {
		return country_specialization;
	}

	public void setCountry_specialization(String country_specialization) {
		this.country_specialization = country_specialization;
	}

	public String getJob_type_specialization() {
		return job_type_specialization;
	}

	public void setJob_type_specialization(String job_type_specialization) {
		this.job_type_specialization = job_type_specialization;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
	
	
	
	
	
	
	
	
	

}
