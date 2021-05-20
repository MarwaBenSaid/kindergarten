package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Enfant;
import tn.esprit.spring.entities.Parent;

public interface IEnfantService {
	public void updateEnfant(Enfant e) ;
	public void addEnfant(Enfant e);
	public List<Enfant> getAllEnfantren();
	public void deleteEnfant(int Enfantid) ;
	public int getNombreEnfantJPQL();
	public String getEnfantFirstnameLastnameById(int EnfantId);
	public Enfant retrieveEnfant(int EnfantId);

}
