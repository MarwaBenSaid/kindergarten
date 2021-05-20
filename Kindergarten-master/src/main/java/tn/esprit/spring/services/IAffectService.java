package tn.esprit.spring.services;


import java.sql.Time;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Affect;

public interface IAffectService {
	
	int addAffect(Affect affect);
	List<String> DisplayAllAffects();
	Long getMaxIdAffect();
	//void ModifyingAffect( Time departureTime , int idAffect);
	void DeletingAffect(int id );
	//void DeletingAllAffects();
	
	
	

}
