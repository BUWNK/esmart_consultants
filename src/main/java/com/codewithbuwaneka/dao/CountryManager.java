package com.codewithbuwaneka.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.model.CountrySpecialization;



public interface CountryManager {
	
	public boolean addCountry(CountrySpecialization countrySpecialization) throws ClassNotFoundException, SQLException;
	public boolean CheckUpdateCountryName(CountrySpecialization countrySpecialization) throws ClassNotFoundException, SQLException;
	public boolean deleteCountry(String countryCode) throws ClassNotFoundException, SQLException;
	public List<CountrySpecialization> getCountries() throws ClassNotFoundException, SQLException;	
	
}
