package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Admin;


@Repository
public interface AdminRepositories extends CrudRepository<Admin, Integer> {

}
