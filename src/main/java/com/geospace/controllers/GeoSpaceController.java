package com.geospace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geospace.exception.IDNotFoundException;
import com.geospace.exception.NameFormatException;
import com.geospace.models.Candidate;
import com.geospace.service.GeoSpaceService;

/**
 * GeoSpaceController
 * Controller class 
 * @author surramli
 *
 */
@RestController
@RequestMapping(path="/entries", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GeoSpaceController {
	
	@Autowired
	private GeoSpaceService geoSpaceService;
	
	/**
	 * getCandidateDetails
	 * Method used to fetch all the candidate information
	 * HTTP Method: GET
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Candidate> getCandidateDetails(){
		return geoSpaceService.getCandidateDetails();
	}

	/**
	 * addCandidateDetails
	 * Method used to add new candidate details
	 * @param candidates
	 * @throws NameFormatException 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void addCandidateDetails(@RequestBody List<Candidate> candidates) throws NameFormatException {
		geoSpaceService.addCandidateDetails(candidates);
	}
	
	/**
	 * getCandidateByName 
	 * Method used to fetch information by firstname / lastname
	 * Http Method: GET
	 * @param name
	 * @return Candidate details
	 * @throws NameFormatException 
	 */
	@RequestMapping("/{name}")
	public List<Candidate> getCandidatesByName(@PathVariable String name) throws NameFormatException {
		return geoSpaceService.getCandidatesByName(name);
	}
	
	/**
	 * updateCandidateDetails
	 * Method used to update a single candidate
	 * @param id
	 * @throws IDNotFoundException 
	 * @throws NameFormatException 
	 */
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public void updateCandidateDetail(@PathVariable Integer id,@RequestBody Candidate candidate) throws IDNotFoundException, NameFormatException {
		geoSpaceService.updateCandidateDetail(id, candidate);
	}
	
	/**
	 * deleteCandidateDetails
	 * Method used to update a single candidate
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public void deleteCandidateDetail(@PathVariable Integer id) {
		geoSpaceService.deleteCandidateDetail(id);
	}
	
	@RequestMapping(path="/status")
	public String testapi() {
		return "working";
	}

}