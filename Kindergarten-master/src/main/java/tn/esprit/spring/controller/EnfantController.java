package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Enfant;
import tn.esprit.spring.services.IEnfantService;

@RestController
public class EnfantController {
	@Autowired
	IEnfantService iEnfantservice;
	

	// http://localhost:8083/SpringMVC/servlet/addEnfant
	//{"idparent": 1,"firstname": "marwa","lastname": "ben said","address": "14 cite nour siliana","phone": 78871276,"picture": null,"email": " marwa@yahoo.fr","password": "123456",}
	
	@PostMapping("/addEnfant")
	@ResponseBody
	public Enfant addEnfant(@RequestBody Enfant enfant)
	{
		iEnfantservice.addEnfant(enfant);
		return enfant;
	}
	
	// Modifier User
		// http://localhost:8081/SpringMVC/servlet/modify-Enfant
		@PutMapping("/modify-Enfant")
		@ResponseBody
		public Enfant updateEnfant(@RequestBody Enfant Enfant) {
		iEnfantservice.updateEnfant(Enfant);
		return Enfant ;
		}
	
	
   
   // URL : http://localhost:8083/SpringMVC/servlet/getEnfantNameById/2
   @GetMapping(value = "getEnfantNameById/{id}")
   @ResponseBody
   public String getEnfantFirstnameLastnameById(@PathVariable("id")int EnfantId) {
		return iEnfantservice.getEnfantFirstnameLastnameById(EnfantId);
	}


    // URL : http://localhost:8083/SpringMVC/servlet/deleteParentById/1
    @DeleteMapping("/deleteEnfantById/{id}") 
	@ResponseBody 
	public void deleteEnfantById(@PathVariable("id")int EnfantId) {
		iEnfantservice.deleteEnfant(EnfantId);
		
	}
  
    
    // URL : http://localhost:8083/SpringMVC/servlet/getNombreEnfantJPQL
    @GetMapping(value = "getNombreEnfantJPQL")
    @ResponseBody
	public int getNombreEnfantJPQL() {
		
		return iEnfantservice.getNombreEnfantJPQL();
	}
    

	 // URL : http://localhost:8083/SpringMVC/servlet/getAllEnfantren
	@GetMapping(value = "/getAllEnfant")
    @ResponseBody
	public List<Enfant> getAllEnfant() {
		
		return iEnfantservice.getAllEnfantren();
	}
	

	
	// http://localhost:8083/retrieve-parent/{idparent}
	@GetMapping("/retrieve-enfant/{id}")
	@ResponseBody
	public Enfant getEnfant(@PathVariable("id") int idenfant) {
	return iEnfantservice.retrieveEnfant(idenfant);
	}
	

}

