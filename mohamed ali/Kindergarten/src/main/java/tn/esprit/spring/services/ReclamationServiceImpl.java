package tn.esprit.spring.services;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.repositories.ReclamationRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationServiceImpl implements IReclamationService {

	@Autowired 
	
	ReclamationRepositories reclamationrepositories ;

	
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
	
	
}
