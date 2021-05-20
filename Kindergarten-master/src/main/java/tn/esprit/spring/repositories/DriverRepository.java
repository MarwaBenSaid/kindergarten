package tn.esprit.spring.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Driver;

@Repository
public interface DriverRepository extends CrudRepository <Driver, Integer> {

	List <Driver> findByCin(String cin);	
	
	@Query("select firstName , lastName , cin from Driver")
	List<String> DisplayAll() ; 
	
	
	
	@Query("SELECT Count(d) FROM Driver d   ")
	Long getMaxIdDriver();
	
	
	
	
	@Modifying (clearAutomatically=true)
	@Transactional
	@Query ("UPDATE Driver d  set d.firstName=:fn , d.lastName=:ln where d.cin=:c ")
	public void ModifyingDriver (@Param("fn")String fn, @Param("ln") String ln , @Param ("c")String id);
	

	
	@Modifying 
	@Transactional
	@Query("DELETE from Driver d  where d.cin =:id ")
	public void DeletingDriver(@Param("id")String id);

	
	
	
	@Modifying 
	@Transactional
	@Query("DELETE from Driver ")
	public void DeletingAllDriver();
	
	
	
	
}
