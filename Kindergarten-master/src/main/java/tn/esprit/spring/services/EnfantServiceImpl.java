package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Enfant;
import tn.esprit.spring.repositories.EnfantRepository;
import tn.esprit.spring.repositories.KindergartenRepository;

@Service
public class EnfantServiceImpl implements IEnfantService{
	
	private static final Logger logger = LogManager.getLogger( EnfantServiceImpl.class);
	@Autowired
	EnfantRepository EnfantRepository;
	@Autowired
	KindergartenRepository kindergartenRepository ;
	
	public void updateEnfant(Enfant c) {
		EnfantRepository.save(c);}

		public void addEnfant(Enfant c){
			EnfantRepository.save(c);}

		public List<Enfant> getAllEnfantren() {
		return (List<Enfant>) EnfantRepository.findAll();
		
		}

		public void deleteEnfant(int Enfantid) {
			EnfantRepository.deleteById(Enfantid);
		}
		public int getNombreEnfantJPQL() {
			return EnfantRepository.countenfant();
		}

		
		public String getEnfantFirstnameLastnameById(int EnfantId) {
			Enfant EnfantManagedEntity = EnfantRepository.findById(EnfantId).get();
			return EnfantManagedEntity.getFirstname();
			
		}

		@Override
		public Enfant retrieveEnfant(int EnfantId) {
			return EnfantRepository.findById(EnfantId).orElse(null);
		}
}
