package com.codewithbuwaneka.service;

import java.sql.SQLException;

import com.codewithbuwaneka.dao.CountryManager;
import com.codewithbuwaneka.dao.CountryManagerImpl;
import com.codewithbuwaneka.dao.UserManager;
import com.codewithbuwaneka.dao.UserManagerImpl;
import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.User;

public class UserService {
	
	private static UserService userServiceObj;
	
	private UserService() {	}
	
	public static synchronized UserService getUserServiceInstance() {
		
		if(userServiceObj == null) {
			userServiceObj = new UserService();
		}
		
		return userServiceObj;
	}
	//-----------------------------services
	public static String authenticate(String username, String password) throws ClassNotFoundException, SQLException {
			
		UserManager userManager = new UserManagerImpl();
		return userManager.authenticate(username, password);

	}
	
	public static boolean register(User user) throws ClassNotFoundException, SQLException {
		UserManager userManager = new UserManagerImpl();
		return userManager.register(user);
	}
	
}
