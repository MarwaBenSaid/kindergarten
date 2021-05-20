package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Driver;
import tn.esprit.spring.repositories.DriverRepository;

@Service
public class DriverServiceImpl implements IDriverService{

@Autowired
DriverRepository driverRepository ; 


public int addDriver (Driver driver)
{driverRepository.save(driver); 
return driver.getDriverId() ; 
}






public List <Driver> findByCin(String cin){
	List <Driver> l ; 
	l=driverRepository.findByCin(cin);
	return l;
}


public List <String>DisplayAll () 
{ return driverRepository.DisplayAll(); }


public Long getMaxIdDriver() {
Long l ; 
l=driverRepository.getMaxIdDriver();
return l ;
}


public void ModifyingDriver (String fn , String ln ,  String cin)
{driverRepository.ModifyingDriver( fn , ln,  cin);	
}




public void DeletingDriver ( String cin)
{driverRepository.DeletingDriver(cin);}



public void DeletingAllDriver ()
{driverRepository.DeletingAllDriver();}







}
