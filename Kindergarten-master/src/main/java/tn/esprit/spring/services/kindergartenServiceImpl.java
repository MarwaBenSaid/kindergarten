package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.kindergarten;
import tn.esprit.spring.repositories.KindergartenRepository;
@Service
public class kindergartenServiceImpl  implements IkindergartenService {
	@Autowired 
	
	
   KindergartenRepository kindergartennrepository;

	

	
	public void updatekindergarten(kindergarten k,int kindergartenid) {
		kindergartennrepository.save(k);
	}


	public void addkindergarten(kindergarten k) {
		kindergartennrepository.save(k);
		
	}

	
	public List<kindergarten> getAllkindergarten() {
		List<kindergarten> k = (List<kindergarten>) kindergartennrepository.findAll();
		return k;
	}

	
	public void deletekindergarten(int kindergartenid) {
		kindergartennrepository.deleteById(kindergartenid);
	} 
	public Object get(int kindergartenid)
	{
		Optional<kindergarten> k = kindergartennrepository.findById(kindergartenid);
		return k;
	}
}
