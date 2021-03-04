package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CandidateRepository;
import tn.esprit.spring.entities.Candidate;

@Service
public class CandidateServiceImpl implements ICandidateService {
	@Autowired 
	CandidateRepository candidaterepository;
	
	public void updateCandidate(Candidate c) {
		candidaterepository.save(c);
		
	}

	
	public void addCandidate(Candidate c) {
		candidaterepository.save(c);
	}

	
	public List<Candidate> getAllCandidate() {
		List<Candidate> c = (List<Candidate>) candidaterepository.findAll();
		return c;
	}

	public void deleteCandidate(int Candidateid) {
		candidaterepository.deleteById(Candidateid);
		
	}
	
	

}
