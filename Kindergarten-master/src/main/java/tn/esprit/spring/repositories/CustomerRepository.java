package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Driver;

 
public interface CustomerRepository extends CrudRepository<Driver, Long>{}