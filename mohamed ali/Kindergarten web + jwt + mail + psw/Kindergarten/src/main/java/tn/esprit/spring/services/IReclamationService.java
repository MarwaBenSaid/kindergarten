package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Reclamation;


public interface IReclamationService {
	
	
	
	public void addReclamation(Reclamation c);

	public List<Reclamation> getAllReclamation() ;

	public void deleteReclamation(int reclamationid) ;

	public int getNombreReclamationJPQL();
	
	public Reclamation saveReclamation(Reclamation reclamation, int idadmin);
	
	public List<Reclamation> findByTitre(String titre);
}
