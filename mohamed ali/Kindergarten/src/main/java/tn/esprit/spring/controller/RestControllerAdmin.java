package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.services.IAdminService;


@RestController
public class RestControllerAdmin {
	
	@Autowired
	IAdminService iadminservice;
	
	
	// URL : http://localhost:8083/SpringMVC/servlet/addAdmin
	//{"idreclamation": 1,"titre": "test","pictureadmin": "","emailadmin" :"dalyamri0@gmail.com","passwordadmin":"dalydaly"}
			
			@PostMapping("/addAdmin")
			@ResponseBody
			public Admin addAdmin(@RequestBody Admin admin)
			{
				iadminservice.addAdmin(admin);
				return admin;
			}
			
			
			 // URL : http://localhost:8083/SpringMVC/servlet/getAllAdmin
			@GetMapping(value = "/getAllAdmin")
		    @ResponseBody
			public List<Admin> getAllAdmin() {
				
				return iadminservice.getAllAdmin();
			}

			
			// URL : http://localhost:8081/SpringMVC/servlet/modify-admin
			@PutMapping("/modify-admin")
			@ResponseBody
			public Admin updateAdmin(@RequestBody Admin admin) {
			iadminservice.updateAdmin(admin);
			return admin ;
			}
}
