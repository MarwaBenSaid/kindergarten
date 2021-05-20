package tn.esprit.spring.repositories;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Affect;

@Repository
public interface AffectRepository extends CrudRepository <Affect, Integer> {

	@Query("SELECT Count(a) FROM Affect a  ")
	Long getMaxIdAffect();
	
		@Query("select idAffect , date from Affect")
	   List<String> DisplayAllAffects() ; 
	
		
		@Modifying 
		@Transactional
		@Query("DELETE from Affect a where a.idAffect =:id ")
		public void DeletingAffect(@Param("id")int id);

}
		
		
	/*
	
	
	@Modifying (clearAutomatically=true)
	@Transactional
	@Query ("UPDATE Affect a set a.departureTime=:dep where a.idAffect=:affectid")
	public void ModifyingAffect (@Param("dep")Time dep, @Param ("affectid")int id);
	

	
	
	
	
	@Modifying 
	@Transactional
	@Query("DELETE from Affect")
	public void DeletingAllAffects();
	
	
	
	
}
*/

