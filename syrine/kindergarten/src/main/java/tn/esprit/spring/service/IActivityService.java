package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Activity;

public interface IActivityService {
	public void updatekActivity(Activity a);
	public void addkActivity(Activity a);

	public List<Activity> getAllActivity();
	public void deleteActivity(int activityid);

	public Activity saveActivity(Activity activity, int idkindergarten, String idfiledb);



}
