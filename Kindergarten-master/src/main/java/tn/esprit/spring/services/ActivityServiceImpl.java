
package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Activity;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.kindergarten;
import tn.esprit.spring.repositories.ActivityRepository;
import tn.esprit.spring.repositories.FileDBRepository;
import tn.esprit.spring.repositories.KindergartenRepository;

@Service
public class ActivityServiceImpl implements IActivityService {
	@Autowired
	ActivityRepository activityrepository;
	@Autowired
 KindergartenRepository kindergartennrepository;
	@Autowired

	FileDBRepository filedbrepository;
	
	public void updatekActivity(Activity a,int idActivity) {
		activityrepository.save(a);
		
	}

	
	public void addkActivity(Activity a) {
		activityrepository.save(a);
		
	}

	
	public List<Activity> getAllActivity() {
		List<Activity> a = (List<Activity>) activityrepository.findAll();
		return a;
	}

	
	public void deleteActivity(int Activityid) {
		activityrepository.deleteById(Activityid);
	}
	
	public Activity saveActivity(Activity activity, int idkindergarten,String idfiledb) {
		kindergarten product1 = kindergartennrepository.findById(idkindergarten).get();
		FileDB product2 =filedbrepository.findById(idfiledb).get();
		activity.setKindergarten(product1);
		activity.setFiledb(product2);

		
		return activityrepository.save(activity);
	}
	
	
	

}
