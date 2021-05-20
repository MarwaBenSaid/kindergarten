package tn.esprit.spring.services;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Appointement;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.kindergarten;
import tn.esprit.spring.entities.shifts;
import tn.esprit.spring.repositories.AppointementRepository;





@Service
public class AppointemenServicetImpl implements IAppointementService {

	@Override
	public void updatekAppointement(Appointement a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Appointement> getAllAppointement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAppointement(int Appointementid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointement getFirstShift(int idkindergarten, int idparent) throws Exception {
		try {
			List<Appointement> appointements  = getAppointementByIdDate(idkindergarten );
			Appointement appointement = getShift(appointements, idparent, idparent);
			kindergarten tmpKindergarten = new kindergarten();
			tmpKindergarten.setIdkindergarten(idkindergarten);
			
			Parent tmpParent = new Parent();
			tmpParent.setIdparent(idkindergarten);
			
			appointement.setKindergarten(tmpKindergarten);
			appointement.setParent(tmpParent);
			
			System.out.println("ADD"+appointement.getDate());
			return addAppointement(appointement) ;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	@Override
	public Appointement getShift(List<Appointement> appointements, int idkindergarten, int idparent) throws Exception {
		try {
			Map<java.util.Date, List<Appointement>> map  = new HashMap<java.util.Date, List<Appointement>>();
			//creating the instance of LocalDate using the day, month, year info

			ZoneId defaultZoneId = ZoneId.systemDefault();
			LocalDate localDate = LocalDate.now();
			java.util.Date lastDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
			for(Appointement appointement : appointements  )
			{
				List<Appointement> tmp = new ArrayList();

				//List<Appointement> tmp = map.get(appointement.getDate().toString());
				if (map.get(appointement.getDate()) != null) {
					tmp = map.get(appointement.getDate());
				}
				System.out.println("MAPEleMENT"+map.get(appointement.getDate()));
		    	 if(tmp.size() < 2) {
					tmp.add(appointement);
					System.out.println();
					map.put(appointement.getDate(), tmp);
				}
			}
			Appointement firstAvailable = new Appointement();
			boolean found = false;
			
			
			kindergarten tmpkindergarten = new kindergarten();
			tmpkindergarten.setIdkindergarten(idkindergarten);
			
			Parent tmpParent = new Parent();
			tmpParent.setIdparent(idparent);
			
			
			
			for (Map.Entry<java.util.Date, List<Appointement>> entry : map.entrySet()) {
				System.out.println(entry.getKey());
				if(entry.getValue().size()<2) {
					firstAvailable = new Appointement(entry.getKey(),tmpParent,tmpkindergarten,shifts.values()[entry.getValue().size()]);
					System.out.println("FOR"+firstAvailable.getDate());
					found = true;
					break;
				}
				lastDate = entry.getKey();
			}
			if(!found) {
				System.out.println("HEEEREEE");

				Calendar cal = Calendar.getInstance();
				cal.setTime(lastDate);
				cal.add(Calendar.DATE, 1); 
				java.util.Date modifiedDate = cal.getTime();
				System.out.println(modifiedDate);

				firstAvailable = new Appointement(modifiedDate,tmpParent,tmpkindergarten,shifts.values()[0]);
			}
			System.out.println("FIRST"+firstAvailable.getDate());

			return firstAvailable;
			} catch (Exception ex) {
				throw new Exception(ex);
			}
	}
	
	
	@Autowired 
	AppointementRepository appointementRepository;
	public List<Appointement> getAppointementByIdDate(int id ) throws Exception {
		try {
			//creating the instance of LocalDate using the day, month, year info

			ZoneId defaultZoneId = ZoneId.systemDefault();
			
		        LocalDate localDate = LocalDate.now();
		 
		        //local date + atStartOfDay() + default time zone + toInstant() = Date
		        Date date = java.sql.Date.valueOf(localDate);
		        List<Appointement> appointements=appointementRepository.getAppointementByIdDate(id, date);
				System.out.println(appointements.size());

		        return appointements;	
		} catch(Exception ex) {
			throw new Exception(ex);
		}
		
	}
	public Appointement addAppointement(Appointement appointement) {
		appointementRepository.save(appointement);
		return appointement;
	}

	
	}
	

	


