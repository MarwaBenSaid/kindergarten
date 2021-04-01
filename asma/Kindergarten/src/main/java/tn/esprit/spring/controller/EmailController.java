package tn.esprit.spring.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import tn.esprit.spring.Repository.CandidateRepository;
import tn.esprit.spring.entities.Candidate;
import tn.esprit.spring.service.EmailSendService;



@RestController
public class EmailController {
    @Autowired
    EmailSendService emailSendService;
	@Autowired
	CandidateRepository candidaterepository;
	@PostMapping("/sendEmail/{idcandidate}")
	@ResponseBody
	public int sendEmail(@PathVariable("idcandidate") int idcandidate) throws IOException, NexmoClientException, MessagingException{
		Candidate c = candidaterepository.findById(idcandidate).orElse(null);
		emailSendService.sendEmail("asma.benmbarek@esprit.tn", "candidature",c.getFirstname(),c);
	
		
	/*	*/
    return 1;
	}
	
	/*
	 * @PostMapping("/sendEmail/{idUser}")
	@ResponseBody
	public int sendEmail(@PathVariable("idUser")int idUser,@RequestBody String msg){
		User user =userR.findById(idUser).orElse(null) ;
		emailSendService.sendEmail(user.getEmail(), "Order", msg);
			NexmoClient client = new NexmoClient.Builder()
				  .apiKey("")
				  .apiSecret("")
				  .build();

				String messageText = "Votre commande a ete effectuée avec succé";
				TextMessage message = new TextMessage("Vonage APIs", "21628140912", messageText);

				SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

				for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
				    System.out.println(responseMessage);
				}
    return 1;
	}
	
	 * 
	 * 
	 */
}
