package tn.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.repositories.ParentRepository;



@Service
public class ParentServiceImpl implements IParentService {

	@Autowired
	ParentRepository parentRepository;
	
	private static final Logger logger = LogManager.getLogger( ParentServiceImpl.class);
	
	//<------------------------------------------->
	public void updateParent(Parent p) {
		parentRepository.save(p);}
	
	  //<----------------------------------------->
		public void addParent(Parent p){
		parentRepository.save(p);}
		//<----------------------------------------->
		public List<Parent> getAllParents() {
		 return (List<Parent>) parentRepository.findAll();
		
		}
		//<----------------------------------------->
		public void deleteParent(int parentid) {
		parentRepository.deleteById(parentid);
		}
		//<----------------------------------------->
		public int getNombreParentJPQL() {
			return parentRepository.countparent();
		}
		//<----------------------------------------->
		public Parent retrieveParent(int idparent) {
			return parentRepository.findById(idparent).orElse(null);	
		}
		//<----------------------------------------->
		public List<String> getAllParentNames() {
			return parentRepository.ParentNames();
		}

		
	

}
