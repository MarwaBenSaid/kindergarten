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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.services.IChildService;
import tn.esprit.spring.services.IkindergartenService;
import tn.esprit.spring.services.IParentService;


@RestController
public class RestControlParent {

	@Autowired
	IParentService iparentservice;
	@Autowired
	IChildService ichildservice;
	@Autowired 
	IkindergartenService ikindergartenservice ;
	

	
	//<----------------------------------------->
	// http://localhost:8083/SpringMVC/servlet/addParent
	//{"idparent": 1,"firstname": "marwa","lastname": "ben said","address": "14 rue république siliana","phone": 78871276,"picture": null,"email": " marwa@yahoo.fr","password": "123456"}
	
	@PostMapping("/addParent")
	@ResponseBody
	public Parent addParent(@RequestBody Parent parent)
	{
		iparentservice.addParent(parent);
		return parent;
	}
	
	
	//<----------------------------------------->
	
	// Modifier Parent
		// http://localhost:8083/updateParent
		@PutMapping("/updateParent/{idparent}")
		@ResponseBody
		public Parent updateParent(@PathVariable("idparent") int idparent , Parent p) {
			 iparentservice.updateParent(idparent, p);
			 return (p);
		}
		

		
		// Modifier email : http://localhost:8083/modifyEmail/10/newemail
		@PutMapping(value = "/modifyEmail/{idparent}/{newemail}") 
		@ResponseBody
		public void mettreAjourEmailByEmployeId(@PathVariable("newemail") String email, @PathVariable("idparent") int idparent) {
			iparentservice.UpdateEmailByParentId(email, idparent);
			
		}
  //<----------------------------------------->
		
		

	 // URL : http://localhost:8083/getAllParents
	@GetMapping(value = "/getAllParents")
    @ResponseBody
	public List<Parent> getAllParents() {
		
		return iparentservice.getAllParents();
	}
	
	//<----------------------------------------->
	
	
	// http://localhost:8083/retrieve-parent/{idparent}
	@GetMapping("/retrieve-parent/{idparent}")
	@ResponseBody
	public Parent getParent(@PathVariable("idparent") int idparent) {
	return iparentservice.retrieveParent(idparent);
	}
	
	//<----------------------------------------->
	
	 // URL : http://localhost:8083/getAllParentNames
    @GetMapping(value = "getAllParentNames")
    @ResponseBody
	public List<String> getAllParentNames() {
		
		return iparentservice.getAllParentNames();
    }
    
	
	//<----------------------------------------->

// URL : http://localhost:8083/deleteParentById/1
@DeleteMapping("/deleteParentById/{idparent}") 
@ResponseBody 
public ResponseEntity<String> deleteParentById(@PathVariable("idparent")int parentId) {
	iparentservice.deleteParent(parentId);
	  return ResponseEntity.ok().body(new String("Deleted successFully"));
	
}

//<----------------------------------------->

// URL : http://localhost:8083/getNombreParentJPQL
@GetMapping(value = "getNombreParentJPQL")
@ResponseBody
public int getNombreParentJPQL() {
	
	return iparentservice.getNombreParentJPQL();
}

    //<------------------------------------------->
    
 // http://localhost:8083/affecterChildAKindergarten/1/1
   /* @PutMapping(value = "/affecterChildAKindergarten/{idchild}/{idkindergarten}") 
	public void affecterChildAKindergarten(@PathVariable("idchild")int childId, @PathVariable("idkindergarten")int kindergartenId) {
		iparentservice.affecterChildAKindergarten(childId, kindergartenId);
	}
  //http://localhost:8083/desaffecterChildDuKindergarten/1/1
   	@PutMapping(value = "/desaffecterChildDuKindergarten/{idchild}/{idkindergarten}") 
   	public void desaffecterChildDuKindergarten(@PathVariable("idchild")int childId, @PathVariable("idkindergarten")int kindId)
   	{
   		iparentservice.desaffecterChildDuKindergarten(childId, kindId);
   	}
   */
    
    @GetMapping("/parent/{pageNo}/{pageSize}")
	public List<Parent> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return iparentservice.findPaginated(pageNo, pageSize);
	}
    
    
    
    
    
    
    
 
    /*
    
 // URL : http://localhost:8083/findAllChildrenByParentJPQL/1
    @GetMapping(value = "findAllChildrenByParentJPQL/{idparent}")
    @ResponseBody
	public List<Child> findAllChildrenByParentJPQL(@PathVariable("idparent")int idparent) {

		return iparentservice.findAllChildrenByParentJPQL(idparent);
	}
	*/

}
