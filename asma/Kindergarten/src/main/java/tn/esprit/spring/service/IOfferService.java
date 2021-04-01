package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import tn.esprit.spring.entities.InfoPostuler;
import tn.esprit.spring.entities.Offer;

public interface IOfferService {
public void updateOffer(Offer o) ;
	
	public void addOffer(Offer o );

	public List<Offer> getAllOffer() ;
	
	//public Optional<Offer> findById(int idoffer);

	public void deleteOffer(int Offerid); 
	
	public Offer saveOffer(Offer offer, int idkindergarten);
	
   public int deleteoldoffer();
   
   public int postuler(int idcandidate, int idoffer);

InfoPostuler getInfoPostulerById(int id);
void deleteInfoPostuler(int id);
List<Offer> orderByNeeds(List<Offer> elements, int[] coefficients,Function<Offer, Double>... getScores);
}
