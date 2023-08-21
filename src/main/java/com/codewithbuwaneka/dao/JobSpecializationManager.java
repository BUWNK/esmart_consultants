package com.codewithbuwaneka.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.JobSpecialization;
import com.codewithbuwaneka.service.JobSpecializationService;



public interface JobSpecializationManager {

	public boolean addJob(JobSpecialization jobSpecialization) throws ClassNotFoundException, SQLException;
	public boolean updateJob(JobSpecialization jobSpecialization) throws ClassNotFoundException, SQLException;
	public boolean deleteJob(String job_type_specialization_id) throws ClassNotFoundException, SQLException;
	public List<JobSpecialization> getJobs() throws ClassNotFoundException, SQLException;	

}
