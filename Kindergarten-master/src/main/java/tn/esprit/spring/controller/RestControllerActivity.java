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

import tn.esprit.spring.entities.Activity;
import tn.esprit.spring.entities.kindergarten;
import tn.esprit.spring.services.IActivityService;
import tn.esprit.spring.services.IkindergartenService;

@RestController
public class RestControllerActivity {

	@Autowired
	IActivityService iactivityservice;
	@Autowired 
	IkindergartenService ikindergartenservice;

	@GetMapping(value = "/getAllActivity")
    @ResponseBody
	public List<Activity> getAll() {
		
		return iactivityservice.getAllActivity();
	}

	//http://localhost:8083/SpringMVC/servlet/addkActivity
	@PostMapping("/addkActivity")
	@ResponseBody
	public Activity addkActivity(@RequestBody Activity activity)
	{
		iactivityservice.addkActivity(activity);

		return activity;
	}
	 //Modifier User
		// http://localhost:8081/SpringMVC/servlet/modify-kindergarten
		@PutMapping("/modify-activity/{idActivity}")
		@ResponseBody
		public Activity updatekindergarten(@RequestBody Activity activity,@PathVariable (value ="idActivity") int idActivity) {
			iactivityservice.updatekActivity(activity, idActivity);
		return activity ;
}

		   // URL : http://localhost:8083/SpringMVC/servlet/getParentFistnameById/2
		  // @GetMapping(value = "getParentFirstnameById/{idparent}")
		   //@ResponseBody
		   //public String getParentFirstnameLastnameById(@PathVariable("idkindergarten")int kindergartenid) {
				//return ikindergartenservice.getParentFirstnameLastnameById(kindergartenid);
			//}
		

		    // URL : http://localhost:8083/SpringMVC/servlet/deleteParentById/1
		    @DeleteMapping("/deleteActivityById/{activityid}") 
			@ResponseBody 
			public void deleteActivityById(@PathVariable("activityid")int activityid) {
				iactivityservice.deleteActivity(activityid);
				
			}
		    @PostMapping("/save/{idkindergarten}/{idfiledb}")
			public Activity addActivity1 ( @RequestBody Activity activity,@PathVariable (value ="idkindergarten") int idkindergarten,@PathVariable (value ="idfiledb") String idfiledb)
			{
				return iactivityservice.saveActivity(activity,idkindergarten,idfiledb);
			}
		    
		   /* @PostMapping("/savek/{idkindergarten}")
			public Activity addActivity2( @RequestBody Activity activity,@PathVariable (value ="idkindergarten") int idkindergarten)
			{
				return iactivityservice.saveActivity(activity,idkindergarten);
			}*/
}
