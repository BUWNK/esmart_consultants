package com.codewithbuwaneka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithbuwaneka.model.Appointment;
import com.codewithbuwaneka.model.AppointmentRequest;

public class AppointmentRequestManagerImpl implements AppointmentRequestManager {


	private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DbConnector mysql = new MySqlDbConnectorImpl();
		return mysql.getConnection();
	}
	
	public boolean updateAppointmnetRequest(AppointmentRequest appointmentRequest) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
		String query = "UPDATE appointments SET status = ? WHERE appointment_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, appointmentRequest.getStatus());
		ps.setString(2, appointmentRequest.getAppointment_id());
		
		System.out.println(appointmentRequest.getAppointment_id());
		System.out.println(appointmentRequest.getStatus());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;

	}


	public List<AppointmentRequest> viewAppointmnet() throws ClassNotFoundException, SQLException {
		
		Connection connection = getconnection();
		String query = "select appointment_id, full_name, address, phone_no, selectedDestination, jobcategory, education, appointment_date, appointment_time, status from appointments ";
		
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		
		List<AppointmentRequest> appointmentRequestList = new ArrayList();
		
		while(rs.next()) {
			
			AppointmentRequest appointmentRequest = new AppointmentRequest();
			
			// appointment.setAppointment_id(rs.getString("appointment_id"));
			
			appointmentRequest.setAppointment_id(rs.getString("appointment_id"));
			appointmentRequest.setFull_name(rs.getString("full_name"));
			appointmentRequest.setAddress(rs.getString("address"));
			appointmentRequest.setPhone_no(rs.getString("phone_no"));
			appointmentRequest.setSelectedDestination(rs.getString("selectedDestination"));
			appointmentRequest.setJobcategory(rs.getString("jobcategory"));
			appointmentRequest.setEducation(rs.getString("education"));
			appointmentRequest.setAppointment_date(rs.getString("appointment_date"));
			appointmentRequest.setAppointment_time(rs.getString("appointment_time"));
			appointmentRequest.setStatus(rs.getString("status"));
			
			appointmentRequestList.add(appointmentRequest);
			
			// System.out.println("Appointmnet List "+ appointmentRequest.getFull_name());
		}
		
		
		st.close();
		connection.close();
		
		return appointmentRequestList;
		
	}

}
