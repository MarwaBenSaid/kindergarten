package tn.esprit.spring.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.repositories.ParentRepository;


	@Service
	public class MailService {

		/*
		 * The Spring Framework provides an easy abstraction for sending email by using
		 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
		 * it as well as a starter module.
		 */
		private JavaMailSender javaMailSender;

		/**
		 * 
		 * @param javaMailSender
		 */
		@Autowired
		public MailService(JavaMailSender javaMailSender) {
			this.javaMailSender = javaMailSender;
		}

		/**
		 * 
		 * @param user
		 * @throws MailException
		 */
	ParentRepository	parentrepository;

		public void sendEmail(Parent Parent) throws MailException {

			/*
			 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
			 * JavaMailSender extends the MailSender Interface which contains send()
			 * function. SimpleMailMessage Object is required because send() function uses
			 * object of SimpleMailMessage as a Parameter
			 */
			

			SimpleMailMessage mail = new SimpleMailMessage();
			
			mail.setTo(Parent.getEmail());
			mail.setSubject("WELCOME TO ABC Kindergarten");
			mail.setText("Reglement");

			/*
			 * This send() contains an Object of SimpleMailMessage as an Parameter
			 */
			javaMailSender.send(mail);
		}

		/**
		 * This function is used to send mail that contains a attachment.
		 * 
		 * @param user
		 * @throws MailException
		 * @throws MessagingException
		 */
		public void sendEmailWithAttachment(Parent Parent) throws MailException, MessagingException {

			MimeMessage message = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper. setTo(Parent.getEmail());
			helper.setSubject("WELCOME TO ABC Kindergarten");
			helper.setText("Please find the attached document or rules below.");

			
			ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
			helper.addAttachment(classPathResource.getFilename(), classPathResource);

			javaMailSender.send(message);
		}

}
