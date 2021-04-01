package tn.esprit.spring.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.Repository.FileDBRepository;
import tn.esprit.spring.entities.Candidate;


@Service
public class EmailSendService {
	@Autowired
	FileDBRepository filedbrepository;
	@Autowired
	private JavaMailSender javaMailSender;
	String fileDownloadUri="";
	public void sendEmail(String to , String subject , String msg, Candidate c) throws IOException, MessagingException{
		String ligneTab="";
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText("Candidature de "+c.getFirstname()+" "+c.getLastname());
    
    
        
        String body = String.valueOf(c.getFiledb().getData());
       
    
        MimeMessage messsg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.setDataHandler( new DataHandler( new ByteArrayDataSource( c.getFiledb().getData(), c.getFiledb().getType() ) ) );
     
        Multipart multipart = new MimeMultipart();
       multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart);
		try {
			helper = new MimeMessageHelper(messsg, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(msg,true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        
		 messsg.setContent(multipart);
		javaMailSender.send(messsg);
		
		
	}

}
