package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.OfferRepository;
import tn.esprit.spring.Repository.kindergartenRepository;
import tn.esprit.spring.entities.Offer;
import tn.esprit.spring.entities.kindergarten;

@Service
public class OfferServiceImpl implements IOfferService {
	@Autowired 
	OfferRepository offerrepository;
	//private kindergarten kindergarten;
	@Autowired 
	
	kindergartenRepository kindergartennrepository;
	
	
	public void updateOffer(Offer o) {
		offerrepository.save(o);
		
	}

	
	public void addOffer(Offer o) {
		offerrepository.save(o);
	}

	
	public List<Offer> getAllOffer() {
		List<Offer> o = (List<Offer>) offerrepository.findAll();
		return o;
	}

	public void deleteOffer(int Offerid) {
		offerrepository.deleteById(Offerid);
		
	}
	
	public Offer saveOffer(Offer offer, int idkindergarten) {
		kindergarten product1 = kindergartennrepository.findById(idkindergarten).get();
		//FileDB product2 =filedbrepository.findById(idfiledb).get();
		offer.setKindergarten(product1);
		//activity.setFiledb(product2);

		
		return offerrepository.save(offer);
	}
	

}