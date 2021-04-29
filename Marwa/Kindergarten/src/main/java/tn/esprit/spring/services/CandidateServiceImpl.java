package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Candidate;
import tn.esprit.spring.repositories.CandidateRepository;

@Service
public class CandidateServiceImpl implements  ICandidateService {
	@Autowired
	CandidateRepository candidaterepository ;
	@Override
	public void updateCandidate(Candidate c) {
		candidaterepository.save(c);
		
	}

	@Override
	public void addCandidate(Candidate c) {
		candidaterepository.save(c);
		
	}

	@Override
	public List<Candidate> getAllCandidate() {
		return (List<Candidate>) candidaterepository.findAll();
	}

	@Override
	public void deleteCandidate(int id) {
		candidaterepository.deleteById(id);
		
	}

}
