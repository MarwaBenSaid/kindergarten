package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Activity;

public interface IActivityService {
	public void updatekActivity(Activity a,int idActivity);
	public void addkActivity(Activity a);

	public List<Activity> getAllActivity();
	public void deleteActivity(int activityid);

	public Activity saveActivity(Activity activity, int idkindergarten, String idfiledb);



}
