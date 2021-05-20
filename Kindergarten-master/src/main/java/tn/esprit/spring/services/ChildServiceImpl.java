package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Child;
import tn.esprit.spring.repositories.ChildRepository;
import tn.esprit.spring.repositories.KindergartenRepository;


@Service
public class ChildServiceImpl implements IChildService{
	
	private static final Logger logger = LogManager.getLogger( ChildServiceImpl.class);
	@Autowired
	ChildRepository childRepository;
	@Autowired
	KindergartenRepository kindergartenRepository ;
	
	public void updateChild(Child c) {
		childRepository.save(c);}

		public void addChild(Child c){
			childRepository.save(c);}

		public List<Child> getAllChildren() {
		return (List<Child>) childRepository.findAll();
		
		}

		public void deleteChild(int childid) {
			childRepository.deleteById(childid);
		}
		public int getNombreChildJPQL() {
			return childRepository.countchild();
		}

		
		public String getChildFirstnameLastnameById(int childId) {
			Child childManagedEntity = childRepository.findById(childId).get();
			return childManagedEntity.getFirstname();
			
		}
/*
	
		public List<Child> getAllChildrenByParent(Parent parent) {
			return childRepository.getAllChildrenByParent(parent);
		}
*/
		
		
		

}
