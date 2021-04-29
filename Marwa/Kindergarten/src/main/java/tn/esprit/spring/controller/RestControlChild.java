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

import tn.esprit.spring.entities.Child;
import tn.esprit.spring.services.IChildService;



@RestController
public class RestControlChild {
	@Autowired
	IChildService ichildservice;

	// http://localhost:8083/SpringMVC/servlet/addChild
	//{"idparent": 1,"firstname": "marwa","lastname": "ben said","address": "14 cite nour siliana","phone": 78871276,"picture": null,"email": " marwa@yahoo.fr","password": "123456",}
	
	@PostMapping("/addChild")
	@ResponseBody
	public Child addChild(@RequestBody Child child)
	{
		ichildservice.addChild(child);
		return child;
	}
	
	// Modifier User
		// http://localhost:8081/SpringMVC/servlet/modify-child
		@PutMapping("/modify-child")
		@ResponseBody
		public Child updateChild(@RequestBody Child child) {
		ichildservice.updateChild(child);
		return child ;
		}
	
	
   
   // URL : http://localhost:8083/SpringMVC/servlet/getChildNameById/2
   @GetMapping(value = "getChildNameById/{idchild}")
   @ResponseBody
   public String getChildFirstnameLastnameById(@PathVariable("idchild")int childId) {
		return ichildservice.getChildFirstnameLastnameById(childId);
	}


    // URL : http://localhost:8083/SpringMVC/servlet/deleteParentById/1
    @DeleteMapping("/deleteChildById/{idchild}") 
	@ResponseBody 
	public void deleteChildById(@PathVariable("idchild")int childId) {
		ichildservice.deleteChild(childId);
		
	}
  
    
    // URL : http://localhost:8083/SpringMVC/servlet/getNombreChildJPQL
    @GetMapping(value = "getNombreChildJPQL")
    @ResponseBody
	public int getNombreChildJPQL() {
		
		return ichildservice.getNombreChildJPQL();
	}
    

	 // URL : http://localhost:8083/SpringMVC/servlet/getAllChildren
	@GetMapping(value = "/getAllChildren")
    @ResponseBody
	public List<Child> getAllChildren() {
		
		return ichildservice.getAllChildren();
	}


}
