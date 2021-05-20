package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Driver;



public interface IDriverService {


	int addDriver(Driver driver);
	
	List <Driver> findByCin(String cin);
	List<String> DisplayAll();
	Long getMaxIdDriver();
	void ModifyingDriver( String fn , String ln , String cin);
	void DeletingDriver(String cin);
	void DeletingAllDriver();
	
	
	
}
