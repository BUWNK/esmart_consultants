package com.codewithbuwaneka.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.dao.AppointmentManager;
import com.codewithbuwaneka.dao.AppointmentManagerImpl;
import com.codewithbuwaneka.dao.AppointmentRequestManager;
import com.codewithbuwaneka.dao.AppointmentRequestManagerImpl;
import com.codewithbuwaneka.model.Appointment;
import com.codewithbuwaneka.model.AppointmentRequest;

public class AppointmentRequestService {
	
private static AppointmentRequestService appointmentRequestService;
	
	private AppointmentRequestService() {}
	
	public static synchronized AppointmentRequestService getAppointmentRequestInstance() {
		
		if(appointmentRequestService == null) {
			
			appointmentRequestService = new AppointmentRequestService();
		}
		return appointmentRequestService;
	}
	
	public List<AppointmentRequest> viewAppointmnet() throws ClassNotFoundException, SQLException {
		
		AppointmentRequestManager appointmentRequestManager = new AppointmentRequestManagerImpl();		
		return appointmentRequestManager.viewAppointmnet();
	}
	
	public static boolean updateAppointmnetRequest(AppointmentRequest appointmentRequest) throws ClassNotFoundException, SQLException {
		
		AppointmentRequestManager appointmentRequestManager = new AppointmentRequestManagerImpl();
        return appointmentRequestManager.updateAppointmnetRequest(appointmentRequest);
	}

}
