package com.codewithbuwaneka.dao;

import java.sql.SQLException;

import com.codewithbuwaneka.model.User;

public interface UserManager {
	
	public String authenticate(String username, String password) throws ClassNotFoundException, SQLException;
	public boolean register(User user) throws ClassNotFoundException, SQLException;

}
