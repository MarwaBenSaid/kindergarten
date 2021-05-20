package tn.esprit.spring.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.services.MailService;

@RestController

public class MailController {

		@Autowired
		private MailService notificationService;
		

private Parent Parent;

		

		/**
		 * 
		 * @return
		 */
@RequestMapping("send-mail")
public String send() {

	/*
	 * Creating a User with the help of User class that we have declared. Setting
	 * the First,Last and Email address of the sender.
	 */
	
	Parent.setEmail("syrine.kerriou@esprit.tn"); //Receiver's email address

	/*
	 * Here we will call sendEmail() for Sending mail to the sender.
	 */
	try {
		notificationService.sendEmail(Parent);
	} catch (MailException mailException) {
		System.out.println(mailException);
	}
	return "Congratulations! Your mail has been send to the parent";
}
		/**
		 * 
		 * @return
		 * @throws MessagingException
		 */
		@RequestMapping("send-mail-attachment")
		public String sendWithAttachment(Parent Parent) throws MessagingException {

		
			Parent.setEmail("syrine.kerriou@esprit.tn");//Receiver's email address

			
			try {
				notificationService.sendEmailWithAttachment(Parent);
			} catch (MailException mailException) {
				System.out.println(mailException);
			}
			return "Congratulations! Your mail has been send to the parent.";
		}
}
