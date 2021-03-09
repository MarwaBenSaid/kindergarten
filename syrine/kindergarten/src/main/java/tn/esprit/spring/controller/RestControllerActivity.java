  package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.service.IActivityService;
import tn.esprit.spring.service.IkindergartenService;

@RestController
public class RestControllerActivity {

	@Autowired
	IActivityService iactivityservice;
	@Autowired 
	IkindergartenService ikindergartenservice;

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
		@PutMapping("/modify-activity")
		@ResponseBody
		public Activity updatekindergarten(@RequestBody Activity activity) {
			iactivityservice.addkActivity(activity);
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
