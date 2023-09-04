package com.codewithbuwaneka.model;

public class Appointment {
	
	private String appointment_id;  
	private String consultant_id;
	private String job_seeker_id;
	private String appointment_date;
	private String appointment_time; 
	private String full_name;  
	private String dob;
	private String gender;
	private String nationality;
	private String passport_no; 
	private String address;  
	private String phone_no;
	private String email;
	private String education;
	private String uni_name; 
	private String job_title;  
	private String experience;
	private String selectedDestination; 
	private String jobcategory;  
	private String job_role;
	private String availability;
	public Appointment() {

	}

	public String getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}
	

	public Appointment(String appointment_id, String consultant_id) {
		this.appointment_id = appointment_id;
		this.consultant_id = consultant_id;
	}

	public Appointment(String appointment_id, String consultant_id, String job_seeker_id, String appointment_date,
			String appointment_time, String full_name, String dob, String gender, String nationality,
			String passport_no, String address, String phone_no, String email, String education, String uni_name,
			String job_title, String experience, String selectedDestination, String jobcategory, String job_role) {
		this.appointment_id = appointment_id;
		this.consultant_id = consultant_id;
		this.job_seeker_id = job_seeker_id;
		this.appointment_date = appointment_date;
		this.appointment_time = appointment_time;
		this.full_name = full_name;
		this.dob = dob;
		this.gender = gender;
		this.nationality = nationality;
		this.passport_no = passport_no;
		this.address = address;
		this.phone_no = phone_no;
		this.email = email;
		this.education = education;
		this.uni_name = uni_name;
		this.job_title = job_title;
		this.experience = experience;
		this.selectedDestination = selectedDestination;
		this.jobcategory = jobcategory;
		this.job_role = job_role;
	}

	public String getConsultant_id() {
		return consultant_id;
	}

	public void setConsultant_id(String consultant_id) {
		this.consultant_id = consultant_id;
	}

	public String getJob_seeker_id() {
		return job_seeker_id;
	}

	public void setJob_seeker_id(String job_seeker_id) {
		this.job_seeker_id = job_seeker_id;
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

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassport_no() {
		return passport_no;
	}

	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getUni_name() {
		return uni_name;
	}

	public void setUni_name(String uni_name) {
		this.uni_name = uni_name;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
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

	public String getJob_role() {
		return job_role;
	}

	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	

}
