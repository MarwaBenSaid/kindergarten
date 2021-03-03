package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.services.IReclamationService;


@RestController
public class RestControllerReclamation {

	
	
			@Autowired
		IReclamationService ireclamationservice;

		// http://localhost:8083/SpringMVC/servlet/addReclamation
		//{"idadmin": 1,"nameadmin": "daly","phone": 96025510,"datereclamation" :date,"nbreclamation":1}
		
		@PostMapping("/addReclamation")
		@ResponseBody
		public Reclamation addReclamation(@RequestBody Reclamation reclamation)
		{
			ireclamationservice.addReclamation(reclamation);
			return reclamation;
		}
		
		
		
		
	 

	    // URL : http://localhost:8083/SpringMVC/servlet/deleteReclamationById/1
	    @DeleteMapping("/deleteReclamationById/{idreclamation}") 
		@ResponseBody 
		public void deleteReclamationById(@PathVariable("idreclamation")int reclamationId) {
			ireclamationservice.deleteReclamation(reclamationId);
			
		}
	  
	    
	    // URL : http://localhost:8083/SpringMVC/servlet/getNombreReclamationJPQL
	    @GetMapping(value = "getNombreReclamationJPQL")
	    @ResponseBody
		public int getNombreReclamationJPQL() {
			
			return ireclamationservice.getNombreReclamationJPQL();
		
		}

		 // URL : http://localhost:8083/SpringMVC/servlet/getAllReclamation
		@GetMapping(value = "/getAllReclamation")
	    @ResponseBody
		public List<Reclamation> getAllReclamation() {
			
			return ireclamationservice.getAllReclamation();
		}

		  

		   
	}
	
	

