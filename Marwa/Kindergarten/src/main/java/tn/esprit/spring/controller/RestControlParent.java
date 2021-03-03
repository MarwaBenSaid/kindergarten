package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.services.IParentService;




@RestController
@CrossOrigin
public class RestControlParent {

	@Autowired
	IParentService iparentservice;
	

	// http://localhost:8083/SpringMVC/servlet/addParent
	//{"idparent": 1,"firstname": "marwa","lastname": "ben said","address": "14 cite nour siliana","phone": 78871276,"picture": null,"email": " marwa@yahoo.fr","password": "123456"}
	
	@PostMapping("/addParent")
	@ResponseBody
	public Parent addParent(@RequestBody Parent parent)
	{
		iparentservice.addParent(parent);
		return parent;
	}
	
	//<----------------------------------------->
	
	// Modifier User
		// http://localhost:8081/SpringMVC/servlet/modify-parent
		@PutMapping("/modify-parent")
		@ResponseBody
		public Parent updateParent(@RequestBody Parent parent) {
		iparentservice.updateParent(parent);
		return parent ;
		}
		
		//<----------------------------------------->
	
    // URL : http://localhost:8083/SpringMVC/servlet/deleteParentById/1
    @DeleteMapping("/deleteParentById/{idparent}") 
	@ResponseBody 
	public void deleteParentById(@PathVariable("idparent")int parentId) {
		iparentservice.deleteParent(parentId);
		
	}
    
  //<----------------------------------------->
    
    // URL : http://localhost:8083/SpringMVC/servlet/getNombreParentJPQL
    @GetMapping(value = "getNombreParentJPQL")
    @ResponseBody
	public int getNombreParentJPQL() {
		
		return iparentservice.getNombreParentJPQL();
	}
    
  //<----------------------------------------->

	 // URL : http://localhost:8083/SpringMVC/servlet/getAllParents
	@GetMapping(value = "/getAllParents")
    @ResponseBody
	public List<Parent> getAllParents() {
		
		return iparentservice.getAllParents();
	}
	
	//<----------------------------------------->
	
	
	// http://localhost:8083/SpringMVC/servlet/retrieve-parent/{idparent}
	@GetMapping("/retrieve-parent/{idparent}")
	@ResponseBody
	public Parent getParent(@PathVariable("idparent") int idparent) {
	return iparentservice.retrieveParent(idparent);
	}
	
	//<----------------------------------------->
	
	 // URL : http://localhost:8083/SpringMVC/servlet/getAllParentNames
    @GetMapping(value = "getAllParentNames")
    @ResponseBody
	public List<String> getAllParentNames() {
		
		return iparentservice.getAllParentNames();
    }

}
