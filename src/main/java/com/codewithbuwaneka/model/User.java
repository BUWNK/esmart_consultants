package com.codewithbuwaneka.model;

public class User {
	
	private String username;  
	private String name;
	private String password;
	private String usertype;
	
	public User() {	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String name, String password, String usertype) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
	
	
	
}
