package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Bus;

@Repository
public interface BusRepository extends CrudRepository <Bus, Integer> {

	List <Bus> findByNbrRegistration(String nbrRegistration);
	
	
	@Query("SELECT b FROM Bus b where b.busId=:busid")
	public Bus findById(@Param("busid")int id);	

	
	//@Query("select nbrRegistration from Bus")
	//List<String> DisplayAll() ; 
	
	
	
	@Query("SELECT b FROM Bus b")
	List <Bus> getAll () ; 
	
	
	@Query("SELECT Count(b) FROM Bus b  ")
	Long getMaxId();
	
	@Modifying (clearAutomatically=true)
	@Transactional
	@Query ("UPDATE Bus b set b.capacity=:cap where b.busId=:busid ")
	public void ModifyingBus (@Param("cap")int cap, @Param ("busid")int id);
	

	
	@Modifying 
	@Transactional
	@Query("DELETE from Bus b where b.busId =:id ")
	public void DeletingBus(@Param("id")int id);

	/*******/
	@Modifying
	@Transactional
	@Query("UPDATE Bus b SET b.nbrRegistration = :nbrRegistration , b.commissioningDate = :commissioningDate , b.nbrServiceYear  = :nbrServiceYear  , b.capacity= :capacity WHERE  b.busId = :busId")
	
	public int updateuser(@Param("nbrRegistration")String nbrRegistration,@Param("commissioningDate")Date commissioningDate,@Param("nbrServiceYear")int nbrServiceYear,
			@Param("capacity")int capacity,@Param("busId")int busId	);
	
	
	@Modifying 
	@Transactional
	@Query("DELETE from Bus ")
	public void DeletingAll();
	
	
	
	
}
