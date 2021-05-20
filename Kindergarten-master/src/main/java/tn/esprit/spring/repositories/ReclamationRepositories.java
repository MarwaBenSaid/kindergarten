package tn.esprit.spring.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reclamation;



@Repository

public interface ReclamationRepositories extends CrudRepository<Reclamation, Integer> {
	@Query("SELECT count(*) FROM Reclamation") 
    public int countr();
	@Query("SELECT a FROM Reclamation a WHERE a.titre LIKE %:titre% ")
	public List<Reclamation> findByTitre(@Param(value = "titre") String titre);

}
