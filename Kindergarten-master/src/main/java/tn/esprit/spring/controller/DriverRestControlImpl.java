package tn.esprit.spring.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Driver;
import tn.esprit.spring.repositories.DriverRepository;
import tn.esprit.spring.services.IDriverService;

@RestController
	public class DriverRestControlImpl {
	@Autowired
	IDriverService driverService;
	
	
	
	// Ajouter driver : http://localhost:8081/SpringMVC/servlet/addDriver
		@PostMapping("/addDriver")
		@ResponseBody
		public int addDriver(@RequestBody Driver d) {
		int driver = driverService.addDriver(d);
		return driver;
		}
	
	
	
	// http://localhost:8081/SpringMVC/servlet/findDriver/{cin}
		@GetMapping("/findDriver/{Cin}")
		@ResponseBody
		public List <Driver> getEmployee(@PathVariable("Cin") String cin) {
		return driverService.findByCin(cin);
		}
	
	
	
	
		// URL : http://localhost:8081/SpringMVC/servlet/retrieve-all-driver
		@GetMapping("/retrieve-all-driver")
		@ResponseBody
		public List<String> getDriver() {
		List<String> list = driverService.DisplayAll();
		return list;
		}
		
			
		
		
		// le nombre des driver
		// http://localhost:8081/SpringMVC/servlet/getMaxIdDriver 
		@GetMapping("/getMaxIdDriver")
		@ResponseBody 
		public Long MaxIdDriver () {
			Long l = driverService.getMaxIdDriver() ; 
			return l ; 
		}
	
	

		// Modifier driver
		// http://localhost:8081/SpringMVC/servlet/modifyDriver/{Cin}
		@PutMapping("/modifyDriver/{Cin}")
		@ResponseBody
		public void updateDriver(@RequestBody String fn , String ln  , @PathVariable("Cin") String cin ) {
		 driverService.ModifyingDriver(fn , ln,  cin );
		}
	
		
		
		// Supprimer driver : http://localhost:8081/SpringMVC/servlet/deleteDriver/{Cin}
		@DeleteMapping("/deleteDriver/{Cin}")
		@ResponseBody
		public void deleteDriver(@PathVariable("Cin") String  cin) {
		driverService.DeletingDriver(cin);
		} 

	
	
	
	// Supprimer  tous les drivers
	// http://localhost:8081/SpringMVC/servlet/deletingAllDrivers
	@DeleteMapping("/deletingAllDrivers")
	@ResponseBody 
	public void deleteAllDriver () {
		driverService.DeletingAllDriver();
	}
	
	
	 
	
	
	
	} 
