package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CandidateRepository;
import tn.esprit.spring.Repository.FileDBRepository;
import tn.esprit.spring.entities.Candidate;
import tn.esprit.spring.entities.FileDB;

@Service
public class CandidateServiceImpl implements ICandidateService {
	@Autowired 
	CandidateRepository candidaterepository;
	@Autowired 
	FileDBRepository filerepository;
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

	public Candidate saveCandidate(Candidate candidate,String idfiledb) {
		FileDB product2 =filerepository.findById(idfiledb).get();
		candidate.setFiledb(product2);

		
		return candidaterepository.save(candidate);
	}
}
