package com.codewithbuwaneka.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.dao.CountryManager;
import com.codewithbuwaneka.dao.CountryManagerImpl;
import com.codewithbuwaneka.model.CountrySpecialization;

public class CountryService {

	private static CountryService countryServiceObj;
	
	private CountryService() {}
	
	public static synchronized CountryService getCountryServiceInstance() {
		if(countryServiceObj == null) {
			countryServiceObj = new CountryService();
		}
		return countryServiceObj;
	}
	
	
	
	//-----------------------------services
	public static boolean addCountry(CountrySpecialization countrySpecialization) throws ClassNotFoundException, SQLException {
		
		CountryManager countryManager = new CountryManagerImpl();
        return countryManager.addCountry(countrySpecialization);
	}
	
	public static boolean CheckUpdateCountryName(CountrySpecialization countrySpecialization) throws ClassNotFoundException, SQLException {
		
		CountryManager countryManager = new CountryManagerImpl();
		return countryManager.CheckUpdateCountryName(countrySpecialization);
	}
	
	public boolean deleteCountry(String countryCode) throws ClassNotFoundException, SQLException {
		
		CountryManager countryManager = new CountryManagerImpl();
		return countryManager.deleteCountry(countryCode);
	}
	
	public List<CountrySpecialization> getCountries() throws ClassNotFoundException, SQLException {
		
		CountryManager countryManager = new CountryManagerImpl();
		
		return countryManager.getCountries();
	}
}
