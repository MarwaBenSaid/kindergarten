package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.kindergarten;
import tn.esprit.spring.repository.kindergartenRepository;
@Service
public class kindergartenServiceImpl  implements IkindergartenService {

	@Autowired 
	
	
   kindergartenRepository kindergartennrepository;

	@Override
	public void updatekindergarten(kindergarten k) {
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
}
