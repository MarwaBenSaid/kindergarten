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
		//{"idparent": 1,"firstname": "marwa","lastname": "ben said","address": "14 cite nour siliana","phone": 78871276,"picture": null,"email": " marwa@yahoo.fr","password": "123456"}
		
		@PostMapping("/addReclamation")
		@ResponseBody
		public Reclamation addReclamation(@RequestBody Reclamation reclamation)
		{
			ireclamationservice.addReclamation(reclamation);
			return reclamation;
		}
		
		
		
		
	 

	    // URL : http://localhost:8083/SpringMVC/servlet/deleteParentById/1
	    @DeleteMapping("/deleteReclamationById/{idreclamation}") 
		@ResponseBody 
		public void deleteReclamationById(@PathVariable("idreclamation")int reclamationId) {
			ireclamationservice.deleteReclamation(reclamationId);
			
		}
	  
	    
	    // URL : http://localhost:8083/SpringMVC/servlet/getNombreParentJPQL
	    @GetMapping(value = "getNombreReclamationJPQL")
	    @ResponseBody
		public int getNombreReclamationJPQL() {
			
			return ireclamationservice.getNombreReclamationJPQL();
		}

		 // URL : http://localhost:8083/SpringMVC/servlet/getAllParents
		@GetMapping(value = "/getAllParents")
	    @ResponseBody
		public List<Reclamation> getAllReclamation() {
			
			return ireclamationservice.getAllReclamation();
		}

		  

		   
	}
	
	

