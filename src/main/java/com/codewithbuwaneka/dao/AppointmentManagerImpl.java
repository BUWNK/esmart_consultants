package com.codewithbuwaneka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithbuwaneka.model.Appointment;
import com.codewithbuwaneka.model.CountrySpecialization;

public class AppointmentManagerImpl implements AppointmentManager {

	private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DbConnector mysql = new MySqlDbConnectorImpl();
		return mysql.getConnection();
	}

	public boolean addAppointmnet(Appointment appointmnet) throws ClassNotFoundException, SQLException {
		
		Connection connection = getconnection();
		
		String query = "INSERT INTO appointments (appointment_id, consultant_id, job_seeker_id, appointment_date, appointment_time, full_name, dob, gender, nationality, passport_no, address, phone_no, email, education, uni_name, job_title, experience, selectedDestination, jobcategory, job_role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, appointmnet.getAppointment_id());
		ps.setString(2, appointmnet.getConsultant_id());
		ps.setString(3, appointmnet.getJob_seeker_id());
		ps.setString(4, appointmnet.getAppointment_date());
		ps.setString(5, appointmnet.getAppointment_time());
		ps.setString(6, appointmnet.getFull_name());
		ps.setString(7, appointmnet.getDob());
		ps.setString(8, appointmnet.getGender());
		ps.setString(9, appointmnet.getNationality());
		ps.setString(10, appointmnet.getPassport_no());
		ps.setString(11, appointmnet.getAddress());
		ps.setString(12, appointmnet.getPhone_no());
		ps.setString(13, appointmnet.getEmail());
		ps.setString(14, appointmnet.getEducation());
		ps.setString(15, appointmnet.getUni_name());
		ps.setString(16, appointmnet.getJob_title());
		ps.setString(17, appointmnet.getExperience());
		ps.setString(18, appointmnet.getSelectedDestination());
		ps.setString(19, appointmnet.getJobcategory());
		ps.setString(20, appointmnet.getJob_role());


		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
		
	}

	public List<Appointment> assignAppointmnet() throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		String query = "SELECT A.appointment_id, A.full_name, A.address, A.phone_no, "
				+ "A.selectedDestination,A.jobcategory,C.availability "
				+ "FROM appointments A "
				+ "INNER JOIN consultants C ON A.consultant_id = C.consultant_id";
		
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		
		List<Appointment> appointmentList = new ArrayList();
		
		while(rs.next()) {
			
			Appointment appointment = new Appointment();
			
			appointment.setAppointment_id(rs.getString("appointment_id"));
			appointment.setFull_name(rs.getString("full_name"));
			appointment.setAddress(rs.getString("address"));
			appointment.setPhone_no(rs.getString("phone_no"));
			appointment.setSelectedDestination(rs.getString("selectedDestination"));
			appointment.setJobcategory(rs.getString("jobcategory"));
			appointment.setAvailability(rs.getString("availability"));
			
			appointmentList.add(appointment);
			
			System.out.println("Appointmnet List "+ appointment.getFull_name());
		}
		
		
		st.close();
		connection.close();
		
		return appointmentList;
	}

	public boolean updateAppointmnet(Appointment appointmnet) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
		String query = "UPDATE appointments SET consultant_id = (SELECT c.consultant_id FROM  consultants  c where c.employee_id=?) WHERE appointment_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(2, appointmnet.getAppointment_id());
		ps.setString(1, appointmnet.getConsultant_id());
		
		System.out.println(appointmnet.getAppointment_id());
		System.out.println(appointmnet.getConsultant_id());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}

}
