package tn.esprit.spring.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Offer;

public interface OfferRepository extends CrudRepository<Offer, Integer> {
	@Transactional
	@Modifying
	@Query("delete from Offer o where datefin < CURRENT_DATE")
	void deleteoldoffer();
}

