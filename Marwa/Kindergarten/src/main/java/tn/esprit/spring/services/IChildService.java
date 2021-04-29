package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Child;

public interface IChildService {

	
	    public void updateChild(Child c) ;
		public void addChild(Child c);
		public List<Child> getAllChildren();
		public void deleteChild(int childid) ;
		public int getNombreChildJPQL();
		public String getChildFirstnameLastnameById(int childId);
}
