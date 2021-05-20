 package tn.esprit.spring.repositories;



 import java.sql.Date;
 import java.time.LocalDate;
 import java.time.ZoneId;
 import java.util.List;

 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.CrudRepository;
 import org.springframework.data.repository.query.Param;
 import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Appointment;
@Repository

 public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
 	
 	@Query("select a from Appointment a where kindergarten_idkindergarten=:id and date>=:date")
     public List<Appointment> getAppointmentByIdDate(@Param("id")int id,@Param ("date") Date date);
 }
