package tn.esprit.spring.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Kindergarten;
import tn.esprit.spring.repositories.KindergartenRepository;
@Service
public class KindergartenServiceImpl  implements IKindergartenService {

	@Autowired 
	
	
   KindergartenRepository kindergartenrepository;

	@Override
	public void updatekindergarten(Kindergarten k) {
		kindergartenrepository.save(k);
	}


	public void addkindergarten(Kindergarten k) {
		kindergartenrepository.save(k);
		
	}

	
	public List<Kindergarten> getAllkindergarten() {
		List<Kindergarten> k = (List<Kindergarten>) kindergartenrepository.findAll();
		return k;
	}

	
	public void deletekindergarten(int kindergartenid) {
		kindergartenrepository.deleteById(kindergartenid);
	} 
}
