package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Candidate;

public interface ICandidateService {

	public void updateCandidate(Candidate c) ;
	public void addCandidate(Candidate c);
	public List<Candidate> getAllCandidate();
	public void deleteCandidate(int id) ;
}
