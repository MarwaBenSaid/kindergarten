package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import tn.esprit.spring.entities.Bus;
import tn.esprit.spring.repositories.BusRepository;

@Service
public class BusServiceImpl implements IBusService{

@Autowired
BusRepository busRepository ; 


public String addBus (Bus bus)
{busRepository.save(bus); 
return bus.getNbrRegistration() ; 
}




public List <Bus> findByNbrRegistration(String nbrRegistration){
	List <Bus> l ; 
	l=busRepository.findByNbrRegistration(nbrRegistration);
	return l;
}


public Bus findById(int id ){
	return busRepository.findById(id);
}





public List <Bus> getAllBuses () 
{ List <Bus> b = busRepository.getAll() ; 
return b ; 
	}


 

/*
//Avant test 
public List <String>DisplayAll () 
{ return busRepository.DisplayAll(); }
*/

public Long getMaxId() {
Long l ; 
l=busRepository.getMaxId();
return l ;
}


public void ModifyingBus (int capacity, int busId)
{busRepository.ModifyingBus( capacity,  busId);	
}




public void DeletingBus ( int busId)
{busRepository.DeletingBus(busId);}




public void DeletingAll ()
{busRepository.deleteAll();}


public int updateuser(Bus b, int busId) {
    
    return  busRepository.updateuser(b.getNbrRegistration(),b.getCommissioningDate(), b.getNbrServiceYear(),b.getCapacity(), b.getBusId()) ;
	}








}
