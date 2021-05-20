package tn.esprit.spring.services;



import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Affect;
import tn.esprit.spring.repositories.AffectRepository;

@Service
public class AffectServiceImpl implements IAffectService{

	


	@Autowired
	AffectRepository affectRepository ; 
	
	
	public List <String>DisplayAllAffects () 
	{ return affectRepository.DisplayAllAffects(); }



	public int addAffect (Affect affect)
	{affectRepository.save(affect); 
	return affect.getIdAffect() ; 
	}


	public Long getMaxIdAffect() {
	Long l ; 
	l=affectRepository.getMaxIdAffect();
	return l ;
	}

	
	public void DeletingAffect ( int id )
	{affectRepository.DeletingAffect(id );}

	
	
} /*
	public void ModifyingAffect (Time departureTime , int idAffect)
	{affectRepository.ModifyingAffect( departureTime, idAffect);	
	}




	



	public void DeletingAllAffects ()
	{affectRepository.deleteAll();}




	






	

}
*/