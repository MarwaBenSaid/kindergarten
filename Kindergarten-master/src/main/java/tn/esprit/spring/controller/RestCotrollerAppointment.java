package tn.esprit.spring.controller;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.repositories.AppointmentRepository;
import tn.esprit.spring.services.AppointmentServiceImpl;
import tn.esprit.spring.services.IAppointmentService;

@RestController

public class RestCotrollerAppointment {

  

      @Autowired
      private AppointmentServiceImpl appointmentService;
      @Autowired
     IAppointmentService iappointmentService;
  	
  	
  	 //Modifier 
  		// http://localhost:8081/SpringMVC/servlet/modify
  		@PutMapping("/modify")
  		@ResponseBody
  		public Appointment updateAppointment(@RequestBody Appointment appointment) {
  			appointmentService.updatekAppointment(appointment);
  		return  appointment;
  }

  		   
  		@GetMapping("/getall")
  		@ResponseBody
  		public List<Appointment> getAllAppointment() {
  			//List<Appointment> AppointmentResponse = (List<Appointment>) appointmentService.getAllAppointment();
  			return appointmentService.getAllAppointment();
  		}

  		    // URL : http://localhost:8083/SpringMVC/servlet/deleteParentById/1
  		    @DeleteMapping("/deleteAppointmentById/{id}") 
  			@ResponseBody 
  			public void deleteAppointmentById(@PathVariable("id")int id) {
  		    	appointmentService.deleteAppointment(id);
  				
  			}
  	  		@PostMapping("/add")
  	  	@ResponseBody
  		  public  ResponseEntity<String> appointmentsAdd(@RequestBody Appointment appointment) throws Exception 
  		{
  			try {
  				iappointmentService.getFirstShift(appointment.getKindergarten().getIdkindergarten(), appointment.getParent().getIdparent());
  				return new ResponseEntity<String>("Réponse du serveur: "+HttpStatus.OK.name(), HttpStatus.OK);
  			} catch (Exception ex) {
  				throw new Exception (ex);
  			}
  		    
  		

}
  
}
	