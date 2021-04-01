package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CandidateRepository;
import tn.esprit.spring.Repository.InfoPostulerRepository;
import tn.esprit.spring.Repository.OfferRepository;
import tn.esprit.spring.Repository.kindergartenRepository;
import tn.esprit.spring.entities.Candidate;
import tn.esprit.spring.entities.InfoPostuler;
import tn.esprit.spring.entities.Offer;
import tn.esprit.spring.entities.kindergarten;

@Service
public class OfferServiceImpl implements IOfferService {
	@Autowired 
	OfferRepository offerrepository;
	//private kindergarten kindergarten;
	@Autowired 
	kindergartenRepository kindergartennrepository;
    @Autowired 
	CandidateRepository candidaterepository;
    @Autowired 
    InfoPostulerRepository infopostulerrepository;
	
	
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
	
    public List<Offer> orderByNeeds(List<Offer> elements, int[] coefficients,Function<Offer, Double>... getScores) {
    	//liste des hashmap ; 1 hashap par critere
        List<HashMap<Offer, Double>> scores=new ArrayList<>();
        for (int i=0;i<getScores.length;i++)
            scores.add(new HashMap<>());
        double[] maxScores=new double[getScores.length];
        Arrays.fill(maxScores, 1);
        //parcourir les offres 
        for (Offer element : elements) {
            for (int i=0;i<getScores.length;i++) {
                double score=getScores[i].apply(element);
                if (score>maxScores[i])
                    maxScores[i]=score;
                scores.get(i).put(element, score);
            }
        }
        HashMap<Offer, Double> finalScore=new HashMap<>();
        for (Offer element : elements) {
            double sum=0;
            for (int i=0;i<getScores.length;i++)
                sum+=(scores.get(i).get(element)/maxScores[i])*100*coefficients[i];
            finalScore.put(element, sum/Arrays.stream(coefficients).sum());
        }
        ArrayList<Map.Entry<Offer, Double>> results=new ArrayList<>(finalScore.entrySet());
        Collections.sort(results, (e1, e2)->e1.getValue().compareTo(e2.getValue()));
        return results.stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }
	
	/*public Optional<Offer> findById(idoffer)
	{
		return offerrepository.findById(idoffer);
	}*/


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


	@Override
	public int deleteoldoffer() {
		// TODO Auto-generated method stub
		offerrepository.deleteoldoffer();
		return 1;
	}


	@Override
	public int postuler(int idcandidate, int idoffer) {
		// TODO Auto-generated method stub
		InfoPostuler p = new InfoPostuler();
		Offer o = offerrepository.findById(idoffer).orElse(null); 
		Candidate c = candidaterepository.findById(idcandidate).orElse(null);
		Date d = new Date();
		p.setOffer(o);
		p.setCandidate(c);
		p.setDatepost(d);
		infopostulerrepository.save(p);
		return 1;
	}
	
  public InfoPostuler getInfoPostulerById(int id)
  {
	  return infopostulerrepository.findById(id).orElse(null);
  }
  
  
  public void deleteInfoPostuler(int id) {
	  infopostulerrepository.deleteById(id);
  }
}