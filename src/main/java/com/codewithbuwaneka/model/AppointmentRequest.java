package com.codewithbuwaneka.model;

public class AppointmentRequest {
	
	String appointment_id;
	String full_name;
	String address;
	String phone_no;
	String selectedDestination;
	String jobcategory;
	String education;
	String appointment_date;
	String appointment_time;
	String status;
	
	public AppointmentRequest() {

	}

	public AppointmentRequest(String appointment_id) {
		this.appointment_id = appointment_id;
	}

	public AppointmentRequest(String appointment_id, String status) {
		this.appointment_id = appointment_id;
		this.status = status;
	}

	public AppointmentRequest(String appointment_id, String full_name, String address, String phone_no,
			String selectedDestination, String jobcategory, String education, String appointment_date,
			String appointment_time) {
		this.appointment_id = appointment_id;
		this.full_name = full_name;
		this.address = address;
		this.phone_no = phone_no;
		this.selectedDestination = selectedDestination;
		this.jobcategory = jobcategory;
		this.education = education;
		this.appointment_date = appointment_date;
		this.appointment_time = appointment_time;
	}

	public String getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getSelectedDestination() {
		return selectedDestination;
	}

	public void setSelectedDestination(String selectedDestination) {
		this.selectedDestination = selectedDestination;
	}

	public String getJobcategory() {
		return jobcategory;
	}

	public void setJobcategory(String jobcategory) {
		this.jobcategory = jobcategory;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getAppointment_time() {
		return appointment_time;
	}

	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
