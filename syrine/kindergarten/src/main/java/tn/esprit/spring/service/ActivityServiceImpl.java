
package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.entity.FileDB;
import tn.esprit.spring.entity.kindergarten;
import tn.esprit.spring.repository.ActivityRepository;
import tn.esprit.spring.repository.FileDBRepository;
import tn.esprit.spring.repository.kindergartenRepository;

@Service
public class ActivityServiceImpl implements IActivityService {
	@Autowired
	ActivityRepository activityrepository;
	@Autowired
 kindergartenRepository kindergartennrepository;
	@Autowired

	FileDBRepository filedbrepository;
	public void updatekActivity(Activity a) {
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
