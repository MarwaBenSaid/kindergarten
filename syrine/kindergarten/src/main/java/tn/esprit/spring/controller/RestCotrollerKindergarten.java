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

import tn.esprit.spring.entity.kindergarten;
import tn.esprit.spring.service.IkindergartenService;

@RestController

public class RestCotrollerKindergarten {
	@Autowired
	IkindergartenService ikindergartenservice;
	// http://localhost:8083/SpringMVC/servlet/addkindergarten
		//{"idkindergarten": 1,"firstname": "marwa","lastname": "ben said","address": "14 cite nour siliana","phone": 78871276,"picture": null,"email": " marwa@yahoo.fr","password": "123456"}
		
		@PostMapping("/addkindergarten")
		@ResponseBody
		public kindergarten addkindergarten(@RequestBody kindergarten kindergarten)
		{
			ikindergartenservice.addkindergarten(kindergarten);
			return kindergarten;
		}
		
		// Modifier User
			// http://localhost:8081/SpringMVC/servlet/modify-kindergarten
			@PutMapping("/modify-kindergarten")
			@ResponseBody
			public kindergarten updatekindergarten(@RequestBody kindergarten kindergarten) {
			ikindergartenservice.updatekindergarten(kindergarten);
			return kindergarten ;
			}
		
		
	 

	    // URL : http://localhost:8083/SpringMVC/servlet/deletekindergartenById/1
	    @DeleteMapping("/deletekindergartenById/{idkindergarten}") 
		@ResponseBody 
		public void deletekindergartenById(@PathVariable("idkindergarten")int kindergartenId) {
			ikindergartenservice.deletekindergarten(kindergartenId);
			
		}
	  
	    
	   

		 // URL : http://localhost:8083/SpringMVC/servlet/getAllkindergartens
		@GetMapping(value = "/getAllkindergartens")
	    @ResponseBody
		public List<kindergarten> getAllkindergartens() {
			
			return ikindergartenservice.getAllkindergarten();
		}

}
