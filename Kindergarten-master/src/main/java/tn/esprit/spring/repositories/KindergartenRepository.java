package tn.esprit.spring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.kindergarten;

@Repository

public interface KindergartenRepository extends CrudRepository<kindergarten, Integer>{


}
