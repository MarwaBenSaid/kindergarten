package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository <Candidate, Integer> {

}
