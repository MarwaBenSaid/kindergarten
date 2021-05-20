package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.kindergarten;

public interface IkindergartenService {
	

public void updatekindergarten(kindergarten k,int kindergartenid) ;
	
	public void addkindergarten(kindergarten k );

	public List<kindergarten> getAllkindergarten() ;

	public void deletekindergarten(int kindergartenid) ;

}
