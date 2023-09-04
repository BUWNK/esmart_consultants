package com.codewithbuwaneka.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.model.Appointment;
import com.codewithbuwaneka.model.AppointmentRequest;

public interface AppointmentRequestManager {

	public boolean updateAppointmnetRequest(AppointmentRequest appointmentRequest) throws ClassNotFoundException, SQLException;
	public List<AppointmentRequest> viewAppointmnet() throws ClassNotFoundException, SQLException;	
}
