package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.IRegistredChildService;


@RestController
public class RegistredChildControlImpl {

	
	
	
	
	@Autowired
	IRegistredChildService registedChildService;
	// http://localhost:8081/SpringMVC/servlet/
	@RequestMapping("/registredChild")
	@ResponseBody
	public String welcome() { return "Bonjour, Bienvenue à l'application de test des Web ServicesREST."; }
	
	
	
	
	
		// URL : http://localhost:8081/SpringMVC/servlet/DisplayRegistredChild 
		@GetMapping("/DisplayRegistredChild")
		@ResponseBody
		public List<String> getRegestredChild() {
		List<String> list =registedChildService.getRegistredChilds();
		return list;
		}
}
