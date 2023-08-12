package com.codewithbuwaneka.model;

import java.sql.Date;

public class employee {

	private String employee_id;
	private String full_name;
	private Date dob;
	private String nic;
	private String user_type;
	private String address;
	private String contact_no;
	private String email;
	private String password;
	
	public employee() {
		
	}
	
	public employee(String employee_id) {
		this.employee_id = employee_id;
	}
	
	public employee(String employee_id, String full_name, Date dob, String nic, String user_type, String address,
			String contact_no, String email, String password) {
		super();
		this.employee_id = employee_id;
		this.full_name = full_name;
		this.dob = dob;
		this.nic = nic;
		this.user_type = user_type;
		this.address = address;
		this.contact_no = contact_no;
		this.email = email;
		this.password = password;
	}

	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	    
	    
}
