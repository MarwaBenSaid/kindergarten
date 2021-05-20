package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Parent;

public interface IParentService {
	
        public List<Parent> getAll() ;
	public void addParent(Parent p);
	
	public void updateParent( int idparent ,Parent p) ;

	public List<Parent> getAllParents() ;

	public void deleteParent(int parentid) ;

	public int getNombreParentJPQL();

	public Parent retrieveParent(int idparent);

	public List<String> getAllParentNames();

	//public void affecterChildAKindergarten(int childId, int kindergartenId);
	
	//public void desaffecterChildDuKindergarten(int childId, int kindergartenId);
	
	public List<Parent> findPaginated(int pageNo,int pageSize);

	public void UpdateEmailByParentId(String email, int idparent);
	
	//public List<Child> getAllChildrenByParent(Parent parent);
	
	//public List<Child> findAllChildrenByParentJPQL(int idparent);



}
