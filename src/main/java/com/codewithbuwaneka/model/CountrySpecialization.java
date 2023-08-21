package com.codewithbuwaneka.model;

public class CountrySpecialization {
	
	private String country_specialization_id;
	private String country_name;
	
	
	public CountrySpecialization() {
		
	}

	public CountrySpecialization(String country_specialization_id) {
		this.country_specialization_id = country_specialization_id;
	}

	public CountrySpecialization(String country_specialization_id, String country_name) {
		this.country_specialization_id = country_specialization_id;
		this.country_name = country_name;
	}

	public String getCountry_specialization_id() {
		return country_specialization_id;
	}

	public void setCountry_specialization_id(String country_specialization_id) {
		this.country_specialization_id = country_specialization_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	
}
