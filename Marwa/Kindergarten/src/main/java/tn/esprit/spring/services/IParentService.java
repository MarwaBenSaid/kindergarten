package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Parent;

public interface IParentService {
	
	
	
	public void updateParent(Parent p) ;
		
	public void addParent(Parent p);

	public List<Parent> getAllParents() ;

	public void deleteParent(int parentid) ;

	public int getNombreParentJPQL();

	public Parent retrieveParent(int idparent);

	public List<String> getAllParentNames();

	public void affecterChildAKindergarten(int childId, int kindergartenId);


}
