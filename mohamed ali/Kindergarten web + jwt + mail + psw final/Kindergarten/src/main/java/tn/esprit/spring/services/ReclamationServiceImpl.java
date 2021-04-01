package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Kindergarten;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.KindergartenRepository;
import tn.esprit.spring.repositories.ReclamationRepositories;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService {

	@Autowired 
	
	ReclamationRepositories reclamationrepositories ;
@Autowired 
	
UserRepository userrepository;

@Autowired 
KindergartenRepository kindergaretnrepository;
	
	public void addReclamation(Reclamation r) {
		reclamationrepositories.save(r);
		
	}

	
	public List<Reclamation> getAllReclamation() {
		List<Reclamation> r = (List<Reclamation>) reclamationrepositories.findAll();
		return r;
	}

	
	public void deleteReclamation(int reclamationid) {
		reclamationrepositories.deleteById(reclamationid);
		
	}

	
	public int getNombreReclamationJPQL() {
		
		return reclamationrepositories.countr();
	}
	
	
	
	
	
	public Reclamation saveReclamation(Reclamation reclamation, int idu , int idkindergarten) 
	{
		User product1 = userrepository.findById(idu).get();
		Kindergarten product2 = kindergaretnrepository.findById(idkindergarten).get();
		
		reclamation.setUser(product1);
		reclamation.setKindergarten(product2);
		
		return reclamationrepositories.save(reclamation);
	}


	public List<Reclamation> findByTitre(String titre) {		
		return (List<Reclamation>) reclamationrepositories.findByTitre(titre);
	}
}
