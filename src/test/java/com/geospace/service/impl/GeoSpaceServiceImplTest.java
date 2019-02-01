package com.geospace.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.geospace.exception.IDNotFoundException;
import com.geospace.exception.NameFormatException;
import com.geospace.models.Candidate;
import com.geospace.models.Fullname;
import com.geospace.repository.GeoSpaceRepository;

@RunWith(MockitoJUnitRunner.class)
public class GeoSpaceServiceImplTest {

	@Mock
	GeoSpaceRepository geoSpaceRepository;
	
	@InjectMocks
	GeoSpaceServiceImpl geoSpaceServiceImpl;

	private List<Candidate> cList;
	
	@Before
	public void setup() {
		cList = new ArrayList<Candidate>();
		Fullname name = new Fullname("Prasad","Ramalingam");
		
		Candidate candidate = new Candidate();
		candidate.setName(name);
		candidate.setInterests("Hockey, Judo, Kabbadi");
		candidate.setProfile("www.somelink.com");
		candidate.setCandidateId(1);
		
		cList.add(candidate);
	}

	@Test
	public void checkCandidateDetails() {		
		when(geoSpaceRepository.findAll()).thenReturn(cList);
		List<Candidate> actualList = geoSpaceServiceImpl.getCandidateDetails();
		assertEquals("Prasad Ramalingam",actualList.get(0).getName().toString());
	}
	
	@Test
	public void checkCandidateDetailsByName() throws NameFormatException {		
		when(geoSpaceRepository.findByNameFirstNameOrNameLastNameAllIgnoreCase("Prasad", "Ramalingam")).thenReturn(cList);
		List<Candidate> actualList = geoSpaceServiceImpl.getCandidatesByName("Prasad Ramalingam");
		assertEquals("Prasad Ramalingam",actualList.get(0).getName().toString());
	}
	
	@Test(expected=NameFormatException.class)
	public void checkCandidateDetailsByNameException() throws NameFormatException {		
		geoSpaceServiceImpl.getCandidatesByName("Prasad Ramlaingam Hello");		
	}
	
	@Test(expected=IDNotFoundException.class)
	public void checkUpdateDetailsError() throws IDNotFoundException, NameFormatException {
		Candidate expected = cList.get(0);
		geoSpaceServiceImpl.updateCandidateDetail(2, expected);				
	}

}
