package tn.esprit.spring.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Offer;
import tn.esprit.spring.service.IOfferService;

@RestController

public class RestCotrollerOffer {
	@Autowired
	IOfferService iofferservice;
	
	
	@PostMapping("/addOffer")
	@ResponseBody
	public Offer addOffer(@RequestBody Offer offer)
	{
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
		
		return iofferservice.getAllOffer();
	}
	
	
	 @PostMapping("/savek/{idkindergarten}")
		public Offer addOffer1( @RequestBody Offer offer,@PathVariable (value ="idkindergarten") int idkindergarten)
		{
			return iofferservice.saveOffer(offer,idkindergarten);
		}
}
	




