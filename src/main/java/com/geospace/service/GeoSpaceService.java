package com.geospace.service;

import java.util.List;

import com.geospace.exception.IDNotFoundException;
import com.geospace.exception.NameFormatException;
import com.geospace.models.Candidate;

/**
 * GeoSpaceService
 * A Service interface with various abstract methods.
 * @author Prasad Ramalingam
 *
 */

public interface GeoSpaceService {
	/**
	 * fetch all candidates information
	 * @return
	 */
	public List<Candidate> getCandidateDetails();
	
	/**
	 * Add candidate details
	 * @param candidates
	 * @throws NameFormatException
	 */
	public void addCandidateDetails(List<Candidate> candidates) throws NameFormatException;
	
	/**
	 * Get candidates by name
	 * @param name
	 * @return
	 * @throws NameFormatException
	 */
	public List<Candidate> getCandidatesByName(String name) throws NameFormatException;
	
	/**
	 * Update candidate information by id
	 * @param id
	 * @param candidate
	 * @throws IDNotFoundException
	 * @throws NameFormatException
	 */
	void updateCandidateDetail(Integer id, Candidate candidate) throws IDNotFoundException, NameFormatException;
	 
	/**
	 * Delete candidate information by ID.
	 * @param id
	 */
	public void deleteCandidateDetail(Integer id);


}
