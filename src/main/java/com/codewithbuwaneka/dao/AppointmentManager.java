package com.codewithbuwaneka.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithbuwaneka.model.Appointment;

public interface AppointmentManager {
	public boolean addAppointmnet(Appointment appointmnet) throws ClassNotFoundException, SQLException;
	public boolean updateAppointmnet(Appointment appointmnet) throws ClassNotFoundException, SQLException;
	public List<Appointment> assignAppointmnet() throws ClassNotFoundException, SQLException;	

	

}
