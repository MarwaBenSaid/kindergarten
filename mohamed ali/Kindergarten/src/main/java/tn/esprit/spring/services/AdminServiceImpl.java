package tn.esprit.spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.repositories.AdminRepositories;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepositories adminrepositories ;
	
	public void updateAdmin(Admin a) {
		
		adminrepositories.save(a);
		
	}

	
	public void addAdmin(Admin a) {
	
		adminrepositories.save(a);
		
	}

	
	public List<Admin> getAllAdmin() {
	
		List<Admin> a = (List<Admin>) adminrepositories.findAll();
		return a;
		
	}

}
