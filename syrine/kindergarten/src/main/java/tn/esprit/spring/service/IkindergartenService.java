package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.kindergarten;

public interface IkindergartenService {
public void updatekindergarten(kindergarten k) ;
	
	public void addkindergarten(kindergarten k );

	public List<kindergarten> getAllkindergarten() ;

	public void deletekindergarten(int kindergartenid) ;
}
