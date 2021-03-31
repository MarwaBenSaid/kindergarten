package tn.esprit.spring.services;


import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.esprit.spring.entities.Child;

import tn.esprit.spring.entities.Kindergarten;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.repositories.ChildRepository;
import tn.esprit.spring.repositories.KindergartenRepository;
import tn.esprit.spring.repositories.PagingRepository;
import tn.esprit.spring.repositories.ParentRepository;







@Service
public class ParentServiceImpl implements IParentService {

	@Autowired
	ParentRepository parentRepository;
	@Autowired
	ChildRepository childRepository;
	@Autowired
	KindergartenRepository kindergartenRepository ;
	@Autowired
	PagingRepository pagingRepository ;
	
	private static final Logger logger = LogManager.getLogger( ParentServiceImpl.class);
	
	//<------------------------------------------->
	public void updateParent(Parent p) {
		parentRepository.save(p);}
	
	  //<----------------------------------------->
		public void addParent(Parent p){
		parentRepository.save(p);
		
		
		}
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
		//<----------------------------------------->
		public void affecterChildAKindergarten(int childId, int kindergartenId) {
			
			Kindergarten kindergartenManagedEntity = kindergartenRepository.findById(kindergartenId).get();
			Child childManagedEntity = childRepository.findById(childId).get();
							
			childManagedEntity.setKindergarten(kindergartenManagedEntity);
			childRepository.save(childManagedEntity);
	
		}
		
		//<----------------------------------------->
		
		public List<Parent> findPaginated(int pageNo, int pageSize) {
			Pageable paging=PageRequest.of(pageNo, pageSize) ;
			Page<Parent> pagedResult = pagingRepository.findAll(paging);
			return pagedResult.toList();
		}
		//<----------------------------------------->
		@Transactional
		public void desaffecterChildDuKindergarten(int childId, int kindergartenId) {
			
			Kindergarten kindergartenManagedEntity = kindergartenRepository.findById(kindergartenId).get();
			Child childManagedEntity = childRepository.findById(childId).get();
			childManagedEntity.setKindergarten(null);
			childRepository.save(childManagedEntity);
	
		}
		//<----------------------------------------->
		/*
		public List<Child> getAllChildrenByParent(Parent parent) {
			return childRepository.getAllChildrenByParent(parent);
		}

*/
		
		/*
		public List<Child> findAllChildrenByParentJPQL(int idparent)
		{
			return parentRepository.findAllChildrenByParentJPQL(idparent);
		}
		*/
	
}
