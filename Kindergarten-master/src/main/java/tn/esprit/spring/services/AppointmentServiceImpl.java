package tn.esprit.spring.services;


import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.kindergarten;
import tn.esprit.spring.entities.shifts;
import tn.esprit.spring.repositories.AppointmentRepository;
import tn.esprit.spring.repositories.ParentRepository;
import tn.esprit.spring.repositories.KindergartenRepository;
@Service
public class AppointmentServiceImpl implements IAppointmentService  { 
	@Autowired
	AppointmentRepository appointmentrepository;
	@Autowired
	 KindergartenRepository kindergartennrepository;
	@Autowired
	ParentRepository parentrepository;
	@Override
	public void updatekAppointment(Appointment a) {
		appointmentrepository.save(a)	;
	}
	@Override
	public List<Appointment> getAllAppointment() {
		List<Appointment> a = (List<Appointment>) appointmentrepository.findAll();
		return a;	}
	@Override
	public void deleteAppointment(int Appointmentid) {
		appointmentrepository.deleteById(Appointmentid);		
	}
	
	
		
	

	
	
	@Override
	public Appointment getFirstShift(int idkindergarten, int idparent) throws Exception {
		try {
			List<Appointment> appointments  = getAppointmentByIdDate(idkindergarten );
			Appointment appointment = getShift(appointments, idkindergarten, idparent);
			kindergarten tmpkindergarten = new kindergarten();
			tmpkindergarten.setIdkindergarten(idkindergarten);
			
			Parent tmpParent = new Parent();
			tmpParent.setIdparent(idparent);
			
			appointment.setKindergarten(tmpkindergarten);
			appointment.setParent(tmpParent);
			
			System.out.println("ADD"+appointment.getDate());
			return addAppointment(appointment) ;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
		
	}
	@Override
	public Appointment getShift(List<Appointment> appointments, int idkindergarten, int idparent) throws Exception {
		try {
			Map<java.util.Date, List<Appointment>> map  = new HashMap<java.util.Date, List<Appointment>>();
			//creating the instance of LocalDate using the day, month, year info

			ZoneId defaultZoneId = ZoneId.systemDefault();
			LocalDate localDate = LocalDate.now();
			java.util.Date lastDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
			for(Appointment appointment : appointments  )
			{
				List<Appointment> tmp = new ArrayList();

				//List<Appointement> tmp = map.get(appointement.getDate().toString());
				if (map.get(appointment.getDate()) != null) {
					tmp = map.get(appointment.getDate());
				}
				System.out.println("MAPEleMENT"+map.get(appointment.getDate()));
		    	 if(tmp.size() < 6) {
					tmp.add(appointment);
					System.out.println();
					map.put(appointment.getDate(), tmp);
				}
			}
			Appointment firstAvailable = new Appointment();
			boolean found = false;
			
			
			kindergarten tmpkindergarten = new kindergarten();
			tmpkindergarten.setIdkindergarten(idkindergarten);
			
			Parent tmpParent = new Parent();
			tmpParent.setIdparent(idparent);
			
			
			
			for (Map.Entry<java.util.Date, List<Appointment>> entry : map.entrySet()) {
				System.out.println(entry.getKey());
				if(entry.getValue().size()<6) {
					firstAvailable = new Appointment(entry.getKey(),tmpParent,tmpkindergarten,shifts.values()[entry.getValue().size()]);
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

				firstAvailable = new Appointment(modifiedDate,tmpParent,tmpkindergarten,shifts.values()[0]);
			}
			System.out.println("FIRST"+firstAvailable.getDate());

			return firstAvailable;
			} catch (Exception ex) {
				throw new Exception(ex);
			}
		}
	
	
	public List<Appointment> getAppointmentByIdDate(int id) throws Exception {
		try {
			//creating the instance of LocalDate using the day, month, year info

			ZoneId defaultZoneId = ZoneId.systemDefault();
			
		        LocalDate localDate = LocalDate.now();
		 
		        //local date + atStartOfDay() + default time zone + toInstant() = Date
		        Date date = java.sql.Date.valueOf(localDate);
		        List<Appointment> appointments=appointmentrepository.getAppointmentByIdDate(id, date);
				System.out.println(appointments.size());

		        return appointments;	
		} catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	
	
	public Appointment addAppointment(Appointment appointment) {
		appointmentrepository.save(appointment);
		return appointment;
	}

	
					
			

}
