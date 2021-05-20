package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import tn.esprit.spring.repositories.RegistredChildRepository;

@Service
public class RegistredChildServiceImpl implements IRegistredChildService{

	@Autowired
	RegistredChildRepository registredChildRepository ; 
	
	

	public List <String> getRegistredChilds () 
	{ return  registredChildRepository.getRegistredChilds();}

	
	
	
	
}
