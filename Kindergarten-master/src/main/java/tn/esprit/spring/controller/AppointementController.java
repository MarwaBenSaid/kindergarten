package tn.esprit.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Appointement;
import tn.esprit.spring.services.IAppointementService;
@RestController
public class AppointementController {
 IAppointementService iApointementservice;
@PostMapping("/appointementsAdd") 
@ResponseBody
	public  ResponseEntity<String> appointementsAdd(@RequestBody Appointement appointement) throws Exception 
	{
		try {
			iApointementservice.getFirstShift(appointement.getKindergarten().getIdkindergarten(), appointement.getParent().getIdparent());
			return new ResponseEntity<String>("Réponse du serveur: "+HttpStatus.OK.name(), HttpStatus.OK);
		} catch (Exception ex) {
			throw new Exception (ex);
		}
}
}
