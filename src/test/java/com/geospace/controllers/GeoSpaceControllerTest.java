package com.geospace.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geospace.models.Candidate;
import com.geospace.models.Fullname;
import com.geospace.service.GeoSpaceService;


@RunWith(SpringRunner.class)
@WebMvcTest(GeoSpaceController.class)																																																																																																																																				
public class GeoSpaceControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private GeoSpaceService geoSpaceService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testAddCandidates() throws Exception {
		
		Fullname name = new Fullname("Prasad","Ramalingam");
		
		Candidate candidate = new Candidate();
		candidate.setName(name);
		candidate.setInterests("Hockey, Judo, Kabbadi");
		candidate.setProfile("www.somelink.com");
		
		List<Candidate> candidateList = java.util.Arrays.asList(candidate);
		
		String content = objectMapper.writeValueAsString(candidateList);
		
		this.mvc.perform(post("/entries")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(content)
				.accept(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		;
		
		verify(geoSpaceService,times(1)).addCandidateDetails(ArgumentMatchers.<Candidate>anyList());

	}
	
	
	@Test
	public void testUpdateCandidate() throws Exception {
		Fullname name = new Fullname("Prasad","Ramalingam");
		
		Candidate candidate = new Candidate();
		candidate.setCandidateId(1);
		candidate.setName(name);
		candidate.setInterests("Hockey, Judo, Kabbadi");
		candidate.setProfile("www.somelink.com");
		
		ArgumentCaptor<Candidate> argument1 = ArgumentCaptor.forClass(Candidate.class);
		ArgumentCaptor<Integer> argument2 = ArgumentCaptor.forClass(Integer.class);
		
		
		String content = objectMapper.writeValueAsString(candidate);
		
		this.mvc.perform(put("/entries/1")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(content)
	            .accept(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		;
		
		verify(geoSpaceService,times(1)).updateCandidateDetail(argument2.capture(),argument1.capture());
		
	}

	@Test
	public void testDeleteCandidate() throws Exception {

		ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
		
		String content = objectMapper.writeValueAsString("");
		
		this.mvc.perform(MockMvcRequestBuilders
				.delete("/entries/{id}","1")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(content)
	            .accept(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		;
		
		verify(geoSpaceService,times(1)).deleteCandidateDetail(argument.capture());
		
	}

}
