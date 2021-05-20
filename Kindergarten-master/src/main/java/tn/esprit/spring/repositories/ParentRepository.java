package tn.esprit.spring.repositories;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Parent;


@Repository

public interface ParentRepository extends CrudRepository<Parent, Integer> {
	
	
	@Query("SELECT count(*) FROM Parent") 
    public int countparent();
	
	@Query("SELECT firstname , lastname  FROM Parent")
    public List<String> ParentNames();
	
	@Modifying
    @Transactional
    @Query("UPDATE Parent p SET p.email=:email1 where p.idparent=:parentId")
    public void UpdateEmailByParentIdJPQL(@Param("email1")String email, @Param("parentId")int parentId);
}
