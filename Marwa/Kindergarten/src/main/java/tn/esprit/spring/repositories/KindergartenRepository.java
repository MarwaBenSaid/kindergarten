package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Kindergarten;

@Repository
public interface KindergartenRepository extends CrudRepository <Kindergarten, Integer>  {
	

}
