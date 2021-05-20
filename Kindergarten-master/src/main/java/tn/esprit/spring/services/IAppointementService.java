package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Appointement;

public interface IAppointementService {

	public void updatekAppointement(Appointement a);

	public List<Appointement> getAllAppointement();

	
	void deleteAppointement(int Appointementid);

	public Appointement getFirstShift(int idkindergarten, int idparent) throws Exception;

	public Appointement getShift(List<Appointement> appointements,int idkindergarten,int idparent) throws Exception;



}
