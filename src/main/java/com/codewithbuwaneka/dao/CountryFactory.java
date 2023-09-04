package com.codewithbuwaneka.dao;

public class CountryFactory {
	
	public static CountryManager getCountryManagerInstance() {
		
		return new CountryManagerImpl();
	}
}
