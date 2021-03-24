package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entities.Offer;

public interface IOfferService {
public void updateOffer(Offer o) ;
	
	public void addOffer(Offer o );

	public List<Offer> getAllOffer() ;

	public void deleteOffer(int Offerid); 
	public Offer saveOffer(Offer offer, int idkindergarten);

}
