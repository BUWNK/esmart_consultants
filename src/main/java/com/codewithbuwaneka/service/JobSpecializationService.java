package com.codewithbuwaneka.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.dao.CountryManager;
import com.codewithbuwaneka.dao.CountryManagerImpl;
import com.codewithbuwaneka.dao.EmployeeManager;
import com.codewithbuwaneka.dao.EmployeeManagerImpl;
import com.codewithbuwaneka.dao.JobSpecializationManager;
import com.codewithbuwaneka.dao.JobSpecializationManagerImpl;
import com.codewithbuwaneka.model.CountrySpecialization;
import com.codewithbuwaneka.model.JobSpecialization;

public class JobSpecializationService {
	
private static JobSpecializationService jobSpecializationServiceObj;
	
	private JobSpecializationService() {}
	
	public static synchronized JobSpecializationService getjobSpecializationInstance() {
		if(jobSpecializationServiceObj == null) {
			jobSpecializationServiceObj = new JobSpecializationService();
		}
		return jobSpecializationServiceObj;
	}
	
	
	//-----------------------------services
	public static boolean addJob(JobSpecialization jobSpecialization) throws ClassNotFoundException, SQLException {
		
		JobSpecializationManager jobSpecializationManager = new JobSpecializationManagerImpl();
        return jobSpecializationManager.addJob(jobSpecialization);
	}
	
	public static boolean updateJob(JobSpecialization jobSpecialization) throws ClassNotFoundException, SQLException {
		
		JobSpecializationManager jobSpecializationManager = new JobSpecializationManagerImpl();
        return jobSpecializationManager.updateJob(jobSpecialization);
	}
	
	public static boolean deleteJob(String job_type_specialization_id) throws ClassNotFoundException, SQLException {
		
		JobSpecializationManager jobSpecializationManager = new JobSpecializationManagerImpl();
        return jobSpecializationManager.deleteJob(job_type_specialization_id);
	}
	
	public List<JobSpecialization> getJobs() throws ClassNotFoundException, SQLException {
		
		JobSpecializationManager jobSpecializationManager = new JobSpecializationManagerImpl();
		
		return jobSpecializationManager.getJobs();
	}

}
