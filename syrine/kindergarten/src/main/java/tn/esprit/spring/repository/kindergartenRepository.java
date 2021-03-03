package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.kindergarten;

@Repository

public interface kindergartenRepository extends CrudRepository<kindergarten, Integer>{

}
