package com.codewithbuwaneka.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.dao.AppointmentManager;
import com.codewithbuwaneka.dao.AppointmentManagerImpl;
import com.codewithbuwaneka.dao.CountryManager;
import com.codewithbuwaneka.dao.CountryManagerImpl;
import com.codewithbuwaneka.model.Appointment;


public class AppointmentService {
	
private static AppointmentService appointmentService;
	
	private AppointmentService() {}
	
	public static synchronized AppointmentService getappointmentInstance() {
		
		if(appointmentService == null) {
			appointmentService = new AppointmentService();
		}
		return appointmentService;
	}
	
	//-----------------------------services
	
	public static boolean addAppointmnet(Appointment appointmnet) throws ClassNotFoundException, SQLException {
		
		AppointmentManager appointmentManager = new AppointmentManagerImpl();
        return appointmentManager.addAppointmnet(appointmnet);
	}
		
	public List<Appointment> assignAppointmnet() throws ClassNotFoundException, SQLException {
			
		AppointmentManager appointmentManager = new AppointmentManagerImpl();		
		return appointmentManager.assignAppointmnet();
	}
	
	public static boolean updateAppointmnet(Appointment appointmnet) throws ClassNotFoundException, SQLException {
		
		AppointmentManager appointmentManager = new AppointmentManagerImpl();
        return appointmentManager.updateAppointmnet(appointmnet);
	}
	
	
}
