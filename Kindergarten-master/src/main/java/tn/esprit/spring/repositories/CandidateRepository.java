package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

}
