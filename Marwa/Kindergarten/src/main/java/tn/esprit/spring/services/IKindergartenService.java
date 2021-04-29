package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Kindergarten;

public interface IKindergartenService {

	void addkindergarten(Kindergarten kindergarten);

	void updatekindergarten(Kindergarten k);

	List<Kindergarten> getAllkindergarten();

	void deletekindergarten(int kindergartenId);

}
