package tn.esprit.spring.controller;



import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import tn.esprit.spring.Repository.CandidateRepository;
import tn.esprit.spring.entities.Candidate;
import tn.esprit.spring.entities.InfoPostuler;
import tn.esprit.spring.entities.Offer;
import tn.esprit.spring.service.EmailSendService;
import tn.esprit.spring.service.ICandidateService;
import tn.esprit.spring.service.IOfferService;

@RestController

public class RestCotrollerOffer {
	@Autowired
	IOfferService iofferservice;
	@Autowired 
	ICandidateService icandidateservice;
	@Autowired
    EmailSendService emailSendService;
	@Autowired
	CandidateRepository candidaterepository;
	
	
	@PostMapping("/addOffer")
	@ResponseBody
	public Offer addOffer(@RequestBody Offer offer)
	{
		System.out.println(offer.getKindergarten().getIdkindergarten());
		iofferservice.addOffer(offer);
		return offer;
	}
	// http://localhost:8083/SpringMVC/servlet/addOffer
	//{"idOffer": 1,"firstname": "marwa","lastname": "ben said","address": "14 cite nour siliana","phone": 78871276,"picture": null,"email": " marwa@yahoo.fr","password": "123456"}
		
	
	
	
	// Modifier User
	// http://localhost:8083/SpringMVC/servlet/modify-Offer
	@PutMapping("/modify-Offer")
	@ResponseBody
	public Offer updateOffer(@RequestBody Offer offer) {
	iofferservice.updateOffer(offer);
	return offer ;
	}

	 // URL : http://localhost:8083/SpringMVC/servlet/deleteOfferById/1
    @DeleteMapping("/deleteOfferById/{idOffer}") 
	@ResponseBody 
	public void deleteOfferById(@PathVariable("idOffer")int offerId) {
		iofferservice.deleteOffer(offerId);
		
	}

	 // URL : http://localhost:8083/SpringMVC/servlet/getAllOffers
	@GetMapping(value = "/getAllOffers")
    @ResponseBody
	public List<Offer> getAllOffers() {
		
		return iofferservice.orderByNeeds(iofferservice.getAllOffer(),
				new int[] {1,2},
				o->(double)o.getKindergarten().getEmployees().size()+o.getKindergarten().getNbremployee(),
				o->(double)new Date().getTime()-o.getDatefin().getTime()
				);
	}
	
	
	
	
	 @PostMapping("/ajouterOffreParUnJardin/{idkindergarten}")
		public Offer addOffer1( @RequestBody Offer offer,@PathVariable (value ="idkindergarten") int idkindergarten)
		{
			return iofferservice.saveOffer(offer,idkindergarten);
		}
	 
	 
	 
	 @Scheduled(fixedRate=60000)
		@DeleteMapping("/deleteOldOffers")
		@ResponseBody
		public void deleteExpiredOffre() {
			
			iofferservice.deleteoldoffer();
		}
	 
	 @PostMapping("/postuler/{idCandidate}/{idOffer}")
	 @ResponseBody
	 public int postuler(@PathVariable (value ="idCandidate") int idCandidate,@PathVariable (value ="idOffer")int idOffer) throws IOException, MessagingException
	 {  Candidate c = candidaterepository.findById(idCandidate).orElse(null);
		emailSendService.sendEmail("asma.benmbarek@esprit.tn", "candidature",c.getFirstname(),c);
		return iofferservice.postuler(idCandidate, idOffer);
	 }
	 
	 @PutMapping("/answer-Offer/{idOffer}/{accepted}")
	 public void answer(@PathVariable (value="idOffer")int idOffer, @PathVariable(value ="accepted")boolean accepted) throws IOException, NexmoClientException {
		 InfoPostuler off = iofferservice.getInfoPostulerById(idOffer);
		 if (accepted) {
			 Candidate c = off.getCandidate();
			 c.setKindergarten(off.getOffer().getKindergarten());
			 iofferservice.deleteInfoPostuler(idOffer);
			 iofferservice.deleteOffer(off.getOffer().getIdoffer());
			 icandidateservice.updateCandidate(c);
			 NexmoClient client = new NexmoClient.Builder()
					  .apiKey("63af4a10")
					  .apiSecret("ni2iDEiwNrAu2v5H")
					  .build();

					String messageText = "Vous étes selectionnés pour cette offre, veuillez nous rappeler pour effectuer un entretient";
					TextMessage message = new TextMessage("Vonage APIs", "+21651599944", messageText);

					SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

					for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
					    System.out.println(responseMessage);
					}
		 }
		 else 
		 {
			 iofferservice.deleteInfoPostuler(idOffer);
		 }
	 }
	 
}
	




