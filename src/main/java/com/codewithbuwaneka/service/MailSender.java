package com.codewithbuwaneka.service;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	
	String email_authString = "buwanekabandara01@gmail.com";
	String email_authPw = "rabdomhpsnsqrgea";
	String jobSeekerEmailString = "dushmanp123@gmail.com";
	
    public static void main(String[] args) {
        sendMail("Test Subject", "This is the email content.");
    }

    public static void sendMail(String subject, String content) {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("email_authString","email_authPw");
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setSubject(subject);
            message.setFrom(new InternetAddress("buwanekabandara01@gmail.com")); // Set the 'From' address
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("jobSeekerEmailString"));
            message.setContent(content, "text/html");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "email_authString","email_authPw");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
