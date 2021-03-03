package tn.esprit.spring.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Reclamation;



@Repository

public interface ReclamationRepositories extends CrudRepository<Reclamation, Integer> {
	@Query("SELECT count(*) FROM Reclamation") 
    public int countr();


}
