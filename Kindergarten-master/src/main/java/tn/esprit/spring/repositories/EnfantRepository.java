
package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Enfant;


@Repository
public interface EnfantRepository extends CrudRepository<Enfant, Integer> {

	@Query("SELECT count(*) FROM Enfant ")
	public int countenfant();
	
	@Query("SELECT firstname , lastname  FROM Enfant ")
    public List<String> EnfantNames();
	

}
