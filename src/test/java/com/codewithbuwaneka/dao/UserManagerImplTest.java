package com.codewithbuwaneka.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UserManagerImplTest {

	@Test
	void testAuthenticate() throws ClassNotFoundException, SQLException {
		String test_un = "b";		
		String test_pw = "c";
		
		UserManager userManager = new UserManagerImpl();
		
		userManager.authenticate(test_un, test_pw);

	}

}
