package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Child;

@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {

	@Query("SELECT count(*) FROM Child ")
	public int countchild();
	
	@Query("SELECT firstname , lastname  FROM Child ")
    public List<String> ChildNames();
}
