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

import tn.esprit.spring.entities.Candidate;
import tn.esprit.spring.service.ICandidateService;

@RestController

public class RestCotrollerCandidate {
	@Autowired

	ICandidateService icandidateservice;
	@PostMapping("/addCandidate")
	@ResponseBody
	public Candidate addCandidate(@RequestBody Candidate candidate)
	{
		icandidateservice.addCandidate(candidate);
		return candidate;
	}
	// http://localhost:8083/SpringMVC/servlet/addCandidate

	// Modifier User
	// http://localhost:8081/SpringMVC/servlet/modify-Candidate
	@PutMapping("/modify-Candidate")
	@ResponseBody
	public Candidate updateCandidate(@RequestBody Candidate candidate) {
	icandidateservice.updateCandidate(candidate);
	return candidate ;
	}

	 // URL : http://localhost:8083/SpringMVC/servlet/deleteCandidateById/1
    @DeleteMapping("/deleteCandidateById/{idCandidate}") 
	@ResponseBody 
	public void deleteCandidateById(@PathVariable("idCandidate")int candidateId) {
		icandidateservice.deleteCandidate(candidateId);
		
	}

	 // URL : http://localhost:8083/SpringMVC/servlet/getAllCandidates
	@GetMapping(value = "/getAllCandidates")
    @ResponseBody
	public List<Candidate> getAllCandidates() {
		
		return icandidateservice.getAllCandidate();
	}
	@PostMapping("/save/{idfiledb}")
	public Candidate addCandidate ( @RequestBody Candidate candidate,@PathVariable (value ="idfiledb") String idfiledb)
	{
		return icandidateservice.saveCandidate(candidate,idfiledb);
	}
}


	
		
		