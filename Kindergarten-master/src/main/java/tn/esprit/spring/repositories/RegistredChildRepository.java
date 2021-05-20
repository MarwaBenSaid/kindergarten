package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Child;

@Repository
public interface RegistredChildRepository extends CrudRepository <Child, Integer>{

	@Query("SELECT firstname , lastname from Child c where c.transportInscrip=1  ")
	 List<String> getRegistredChilds();
	
	
	
}
