
package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Activity;
import tn.esprit.spring.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements IActivityService {
	@Autowired
	ActivityRepository activityrepository;
	
	public void updatekActivity(Activity a) {
		activityrepository.save(a);
		
	}

	;
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

}
