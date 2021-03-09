package tn.esprit.spring.services;

import java.util.List;



import tn.esprit.spring.entities.Admin;

public interface IAdminService {
	
	public void updateAdmin(Admin a) ;
	
	public void addAdmin(Admin a,String idfiledb);

	public List<Admin> getAllAdmin() ;
	
	


}
