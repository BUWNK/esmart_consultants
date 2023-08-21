package com.codewithbuwaneka.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.model.ConsultantsAvailability;
import com.codewithbuwaneka.model.CountrySpecialization;

public interface ConsultantsAvailabilityManager {

	public List<ConsultantsAvailability> getConsultantsAvailability() throws ClassNotFoundException, SQLException;
}
