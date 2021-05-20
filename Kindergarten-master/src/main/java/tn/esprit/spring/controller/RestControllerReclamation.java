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
		//{"idreclamation": 1,"titre": "test","description":"rec sur test","date":date,"nbreclamation":1}
		
		@PostMapping("/Users/addReclamation")
		@ResponseBody
		public Reclamation addReclamation(@RequestBody Reclamation reclamation)
		{
			ireclamationservice.addReclamation(reclamation);
			return reclamation;
		}
		
		
		
		
	 

	    // URL : http://localhost:8083/SpringMVC/servlet/deleteReclamationById/1
	    @DeleteMapping("/Admin/deleteReclamationById/{idreclamation}") 
		@ResponseBody 
		public void deleteReclamationById(@PathVariable("idreclamation")int reclamationId) {
			ireclamationservice.deleteReclamation(reclamationId);
			
		}
	  
	    
	    // URL : http://localhost:8083/SpringMVC/servlet/getNombreReclamationJPQL
	    @GetMapping(value = "/Admin/getNombreReclamationJPQL")
	    @ResponseBody
		public int getNombreReclamationJPQL() {
			
			return ireclamationservice.getNombreReclamationJPQL();
		
		}

		 // URL : http://localhost:8083/SpringMVC/servlet/getAllReclamation
		@GetMapping(value = "/Admin/getAllReclamation")
	    @ResponseBody
		public List<Reclamation> getAllReclamation() {
			
			return ireclamationservice.getAllReclamation();
		}

		  
		@PostMapping("/Users/save/{idu}/{idkindergarten}")
		public Reclamation addReclamation1 ( @RequestBody Reclamation reclamation,@PathVariable (value ="idu") int idu,@PathVariable (value ="idkindergarten") int idkindergarten)
		{
			return ireclamationservice.saveReclamation(reclamation,idu,idkindergarten);
		}
		
		@GetMapping("/Admin/Search/{titre}")
		public List<Reclamation> getByNameTitre(@PathVariable String titre) {
		return ireclamationservice.findByTitre(titre);
		}
		   
	}
	
	

