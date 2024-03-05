package com.clickncash.service;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String FROM_EMAIL;
	@Value("${spring.mail.password}")
	private String PASSWORD;
	@Value("${dailyReport.To}")
	private String ACC_REPORT_EMAIL;

	@Async
	public String sendMail(String to, String subject, String message) {
		Properties properties = System.getProperties();
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
			}
		});

		// compose message
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM_EMAIL));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
//		            "rainet.tech@gmail.com"));
			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
		            "abc@gmail.com"));
			msg.setSubject(subject);
			msg.setContent(message, "text/html");
			emailSender.send(msg);
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in sending mail to : " + to);
			return "Failure :" + e.getMessage();
		}
	}

	@Async
	public String sendDailyReportMail(String subject, String message, byte[] streamBytes, String fileName) {
		Properties properties = System.getProperties();
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
			}
		});

		// compose message
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM_EMAIL));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(ACC_REPORT_EMAIL));
			msg.setSubject(subject);
			// Create the message part
			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setContent(message, "text/html");
			multipart.addBodyPart(messageBodyPart);

			BodyPart attachmentBodyPart = new MimeBodyPart();
			ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource(streamBytes, "application/vnd.ms-excel");
			attachmentBodyPart.setDataHandler(new DataHandler(byteArrayDataSource));
			attachmentBodyPart.setFileName(fileName + ".xls");
			multipart.addBodyPart(attachmentBodyPart);
			msg.setContent(multipart);

			// Send message
			emailSender.send(msg);
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in sending daily mail ");
			return "Failure :" + e.getMessage();
		}
	}

	
	
}
