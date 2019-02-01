package com.geospace.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.geospace.models.Candidate;

public interface GeoSpaceRepository extends CrudRepository<Candidate, Integer> {

	/**
	 * findByNameFirstNameOrNameLastNameAllIgnoreCase
	 * Find name by first name or by first name and last name
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	List<Candidate> findByNameFirstNameOrNameLastNameAllIgnoreCase(String firstname, String lastname);

}
