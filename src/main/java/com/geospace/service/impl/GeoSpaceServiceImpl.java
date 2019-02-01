package com.geospace.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geospace.exception.IDNotFoundException;
import com.geospace.exception.NameFormatException;
import com.geospace.models.Candidate;
import com.geospace.repository.GeoSpaceRepository;
import com.geospace.service.GeoSpaceService;

/**
 * Service class implementation
 * @author Prasad Ramalingam
 *
 */
@Service
public class GeoSpaceServiceImpl implements GeoSpaceService {

	@Autowired
	private GeoSpaceRepository geoSpaceRepository;

	
	@Override
	public List<Candidate> getCandidateDetails() {
		List<Candidate> candidates = new ArrayList<Candidate>();
		geoSpaceRepository.findAll().forEach(candidates::add);
		return candidates;
	}

	@Override
	public void addCandidateDetails(List<Candidate> candidates) throws NameFormatException {

		for (Candidate candidate : candidates) {

			if (candidate.getName().toString() != null) {
				
				int len = candidate.getName().toString().split(" ").length;

				// Throw Exception in case name is not in proper format.
				if (len != 2) {
					throw new NameFormatException("Please check the name format.");
				}

			} else {
				throw new NameFormatException("Please check the name format.");
			}

			geoSpaceRepository.save(candidate);
		}
	}

	@Override
	public List<Candidate> getCandidatesByName(String name) throws NameFormatException {
		List<Candidate> candidates = new ArrayList<Candidate>();
		String splitName[] = name.split(" ");

		String firstname = "";
		String lastname = "";

		if (splitName.length < 3) {
			if (splitName.length == 2) {
				firstname = splitName[0];
				lastname = splitName[1];
			} else {
				firstname = splitName[0];
			}
		} else {
			throw new NameFormatException("Please check the name format.");
		}

		geoSpaceRepository.findByNameFirstNameOrNameLastNameAllIgnoreCase(firstname, lastname).forEach(candidates::add);
		
		return candidates;
	}

	@Override
	public void updateCandidateDetail(Integer id, Candidate candidate) throws IDNotFoundException, NameFormatException {
		Optional<Candidate> dbCandidate = geoSpaceRepository.findById(id);

		if (dbCandidate.isPresent()) {
			candidate.setCandidateId(id);

			if (candidate.getName().toString() != null) {
				int len = candidate.getName().toString().split(" ").length;
				if (len != 2) {
					throw new NameFormatException("Please check the name format.");
				}
			} else {
				throw new NameFormatException("Please check the name format.");
			}

			geoSpaceRepository.save(candidate);

		} else {
			throw new IDNotFoundException("Please check the candidate ID");
		}

	}

	@Override
	public void deleteCandidateDetail(Integer id) {
		geoSpaceRepository.deleteById(id);
	}

}