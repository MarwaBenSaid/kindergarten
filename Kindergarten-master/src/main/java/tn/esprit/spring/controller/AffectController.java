package tn.esprit.spring.controller;


import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Affect;
import tn.esprit.spring.services.IAffectService;

@RestController
	public class AffectController {
	@Autowired
	IAffectService affectService;
	// http://localhost:8081/SpringMVC/servlet/
	@RequestMapping("/affect")
	@ResponseBody
	public String welcome() { return "Bonjour, Bienvenue à l'application de test des Web ServicesREST."; }
	
	
	
	// Ajouter Bus : http://localhost:8081/SpringMVC/servlet/addAffect
		@PostMapping("/addAffect")
		@ResponseBody
		public int addAffect(@RequestBody Affect a) {
		int affect = affectService.addAffect(a);
		return affect;
		}
	
		
		
		
		
		// URL :http://localhost:8081/SpringMVC/servlet/getMaxIdAffect
			@GetMapping("/getMaxIdAffect")
			@ResponseBody 
			public Long MaxId () {
				Long l = affectService.getMaxIdAffect() ; 
				return l ; 
			}
		


			
	
		// URL : http://localhost:8081/SpringMVC/servlet/retrieve-all-affects
		@GetMapping("/retrieve-all-affects")
		@ResponseBody
		public List<String> getAffect() {
		List<String> list = affectService.DisplayAllAffects();
		return list;
		}
		
		// Supprimer affect : http://localhost:8081/SpringMVC/servlet/deleteAffect/{affectId}
				@DeleteMapping("/deleteAffect/{idAffect}")
				@ResponseBody
				public void deleteAffect(@PathVariable("idAffect") int id ) {
				affectService.DeletingAffect(id );
				} 
		
}	
	/*
		// 
	
		
		// http://localhost:8081/SpringMVC/servlet/modifyAffect/{idAffect}
		@PutMapping("/modifyAffect/{idAffect}")
		@ResponseBody
		public void updateAffect(@RequestBody Time  departureTime , @PathVariable("idAffect") int affectId ) {
		 affectService.ModifyingAffect(departureTime, affectId);
		}
	
		
		
		

	
	
	
	
	// http://localhost:8081/SpringMVC/servlet/deletingAll
	@DeleteMapping("/deletingAllAffect")
	@ResponseBody 
	public void deleteAll () {
		affectService.DeletingAllAffects();
	}
	
	
	
	
	
	} */
