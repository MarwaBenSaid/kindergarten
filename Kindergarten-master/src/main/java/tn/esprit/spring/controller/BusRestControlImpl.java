package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import tn.esprit.spring.entities.Bus;
import tn.esprit.spring.repositories.BusRepository;
import tn.esprit.spring.services.BusServiceImpl;
import tn.esprit.spring.services.IBusService;

@RestController
	public class BusRestControlImpl {
	@Autowired
	IBusService busService;
	@Autowired
	BusServiceImpl use;
	 @Autowired
	  BusRepository busRepository;
	 
	// http://localhost:8081/SpringMVC/servlet/
	@RequestMapping("/")
	@ResponseBody
	public String welcome() { return "Bonjour, Bienvenue à l'application de test des Web ServicesREST."; }
	
	
	
	// Ajouter Bus : http://localhost:8081/SpringMVC/servlet/addBus
		@PostMapping("/addBus")
		@ResponseBody
		public String addBus(@RequestBody Bus b) {
		String bus = busService.addBus(b);
		return bus;
		}
	
	
	
	// http://localhost:8081/SpringMVC/servlet/findBus/{NbrRegistration}
		@GetMapping("/findBus/{NbrRegistration}")
		@ResponseBody
		public List <Bus> getEmployee(@PathVariable("NbrRegistration") String nbrRegistration) {
		return busService.findByNbrRegistration(nbrRegistration);
		}
		
		
		
		// http://localhost:8081/SpringMVC/servlet/findBus/{NbrRegistration}
				@GetMapping("/findBusId/{BusId}")
				@ResponseBody
				public Bus getBus(@PathVariable("BusId")int busid) {
				return busService.findById(busid);
				}
		
		
	
	
	/*	// URL : http://localhost:8081/SpringMVC/servlet/retrieve-all-bus
				@GetMapping("/retrieve-all-bus")
				@ResponseBody
				public List<Bus> DisplayAll() {
				List<Bus> list = busService.findAll();
				return list;
		
				}
		
				
				
				
				
	
	
		// URL : http://localhost:8081/SpringMVC/servlet/retrieve-all-bus
		@GetMapping("/retrieve-all-bus")
		@ResponseBody
		public List<String> getBus() {
		List<String> list = busService.DisplayAll();
		return list;
		}
		*/
		
		
		
		@GetMapping("/getAllBuses")
		@ResponseBody 
		public List<Bus> getAllBuses () {
			List<Bus> b  = busService.getAllBuses() ; 
			return b ; 
		}
		
		
		// le nombre des bus
		// http://localhost:8081/SpringMVC/servlet/getMaxId 
		@GetMapping("/getMaxId")
		@ResponseBody 
		public Long MaxId () {
			Long l = busService.getMaxId() ; 
			return l ; 
		}
	
	
	
		// Modifier bus
		// http://localhost:8081/SpringMVC/servlet/modifyBus/{BusId}
		@PutMapping("/modifyBus/{BusId}")
		@ResponseBody
		public void updateBus(@RequestBody int capacity , @PathVariable("BusId") int busId ) {
		 busService.ModifyingBus(capacity, busId);
		}
	
		
		
		// Supprimer bus : http://localhost:8081/SpringMVC/servlet/deleteBus/{BusId}
		@DeleteMapping("/deleteBus/{BusId}")
		@ResponseBody
		public void deleteBus(@PathVariable("BusId") int  busId) {
		busService.DeletingBus(busId);
		} 

	
	
	
	// Supprimer  tous les bus
	// http://localhost:8081/SpringMVC/servlet/deletingAll
	@DeleteMapping("/deletingAll")
	@ResponseBody 
	public void deleteAll () {
		busService.DeletingAll();
	}
	
	
	
	@GetMapping(value = "getBusById/{id}")
    @ResponseBody
    public Bus getBusById(@PathVariable("id")int id) {
 		return use.findById(id);
 	}
	
	 @PutMapping("/update-bus/{busId}")  
		private Bus updateUser(@RequestBody Bus bb, @PathVariable("busId")int busId)   
		{  
		 use.updateuser(bb, busId);  
			return bb;  
		}
   
	
	
	
	} 
