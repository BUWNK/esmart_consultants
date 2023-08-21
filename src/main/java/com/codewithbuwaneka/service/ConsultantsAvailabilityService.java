package com.codewithbuwaneka.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.dao.ConsultantsAvailabilityManager;
import com.codewithbuwaneka.dao.ConsultantsAvailabilityManagerImpl;
import com.codewithbuwaneka.dao.CountryManager;
import com.codewithbuwaneka.dao.CountryManagerImpl;
import com.codewithbuwaneka.model.ConsultantsAvailability;
import com.codewithbuwaneka.model.CountrySpecialization;

public class ConsultantsAvailabilityService {

	private static ConsultantsAvailabilityService consultantsAvailabilityService;
	
	private ConsultantsAvailabilityService() {}
	
	public static synchronized ConsultantsAvailabilityService getConsultantsAvailabilityInstance() {
		
		if(consultantsAvailabilityService == null) {
			consultantsAvailabilityService = new ConsultantsAvailabilityService();
		}
		return consultantsAvailabilityService;
	}
	
	//-----------------------------services
	
	public List<ConsultantsAvailability> getConsultantsAvailability() throws ClassNotFoundException, SQLException {
		
		ConsultantsAvailabilityManager consultantsAvailabilityManager = new ConsultantsAvailabilityManagerImpl();
		
		return consultantsAvailabilityManager.getConsultantsAvailability();
	}
}
