package tn.esprit.spring.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.repositories.AdminRepositories;
import tn.esprit.spring.repositories.FileDBRepository;

@Service
public class AdminServiceImpl implements IAdminService {
	
	public static List<Admin> a = new ArrayList();
	
    @Autowired
	AdminRepositories adminrepositories ;
	@Autowired
	FileDBRepository filedbrepository ;
	
	public void updateAdmin(Admin a) {
		
		adminrepositories.save(a);
		
	}

	
	public void addAdmin(Admin a,String idfiledb) {
		FileDB product2 =filedbrepository.findById(idfiledb).get();
		a.setFiledb(product2);
		adminrepositories.save(a);
		
	}

	
	public List<Admin> getAllAdmin() {
	
		List<Admin> a = (List<Admin>) adminrepositories.findAll();
		return a;
		
	}
	

	

	
	
	
}
