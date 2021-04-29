package tn.esprit.spring.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Parent;

@Repository

public interface ParentRepository extends CrudRepository<Parent, Integer> {
	
	
	@Query("SELECT count(*) FROM Parent") 
    public int countparent();
	
	@Query("SELECT firstname , lastname  FROM Parent")
    public List<String> ParentNames();
	
	

}
