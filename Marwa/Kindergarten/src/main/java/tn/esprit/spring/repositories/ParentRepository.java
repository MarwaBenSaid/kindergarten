package tn.esprit.spring.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Child;
import tn.esprit.spring.entities.Parent;


@Repository

public interface ParentRepository extends CrudRepository<Parent, Integer> {
	
	
	@Query("SELECT count(*) FROM Parent") 
    public int countparent();
	
	@Query("SELECT firstname , lastname  FROM Parent")
    public List<String> ParentNames();
	
	//@Query("select DISTINCT c from Child c join c.parent p join p.children par where par.id=:idparent")
	//@Query("SELECT Child.idchild FROM Child INNER JOIN Parent ON Child.parent=Parent.idparent")
//	public List<Child> findAllChildrenByParentJPQL(@Param("idparent")int idparent);
	

}
