package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
	
	
	
	@Query("select DISTINCT e from Bill e "
			+ "join e.parent m "
			+ "where m.id=:idparent")
public List<Bill> getAllBillByParent(@Param("idparent")int idparent);
	//////////////////////////////////////////////////////////////////


	@Query("SELECT count (*)  from Child c where c.parent.id=:parent AND c.kindergarten.id=:kindergarten") 
	public int getNumberOfChildForParentInKinderJPQL(@Param("parent") int parent,@Param("kindergarten") int kindergarten);
///////////////////////////////////////////////////////////////////////////

	@Query("select DISTINCT e from Bill e "
			+ "join e.kindergarten m "
			+ "where m.id=:idkindergarten")
public List<Bill> getAllBillBykinder(@Param("idkindergarten")int idkindergarten);
	
	
	
	@Query("select DISTINCT e from Bill e "
			+ "join e.kindergarten k  "
			+"join e.parent u "
			+ "where k.id=:idkindergarten AND u.id =:idparent")
public List<Bill> getAllBillForParentInKinder(@Param("idkindergarten")int idkindergarten  , @Param("idparent")int idparent);
}

