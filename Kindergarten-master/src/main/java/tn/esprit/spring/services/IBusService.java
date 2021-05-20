package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Bus;

public interface IBusService {
	
	String addBus(Bus bus);
	List <Bus> findByNbrRegistration(String nbrRegistration);
	//List<String> DisplayAll();
	List <Bus> getAllBuses () ; 
	public Bus findById (int id); 
	Long getMaxId();
	void ModifyingBus( int capacity , int busId);
	void DeletingBus(int busId);
	void DeletingAll();
	 //public UserConsomi findById(int User_id);
	
	
	

}
