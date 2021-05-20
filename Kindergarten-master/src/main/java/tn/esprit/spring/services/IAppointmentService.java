package tn.esprit.spring.services;


import java.util.List;


import tn.esprit.spring.entities.Appointment;

public interface IAppointmentService {



	public void updatekAppointment(Appointment a);

	public List<Appointment> getAllAppointment();

	
	void deleteAppointment(int Appointmentid);

	public Appointment getFirstShift(int idkindergarten, int idparent) throws Exception;

	public Appointment getShift(List<Appointment> appointments,int idkindergarten,int idparent) throws Exception;








	

	

}
