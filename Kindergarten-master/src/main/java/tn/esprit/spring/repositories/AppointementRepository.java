package tn.esprit.spring.repositories;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Appointement;

@Repository

public interface AppointementRepository extends CrudRepository<Appointement, Integer> {
	
	@Query("select a from Appointement a where kindergarten_idkindergarten=:id and date>=:date")
    public List<Appointement> getAppointementByIdDate(@Param("id")int id,@Param ("date") Date date);
}
