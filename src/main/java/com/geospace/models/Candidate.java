package com.geospace.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Candidate
 * This class is used to store Candidate information.
 * @author Prasad Ramalingam
 *
 */
@Entity
@Table(name = "GEO_Candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int candidateId;
	@Embedded
	private Fullname name;
	private String interests;
	private String profile;

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public Fullname getName() {
		return name;
	}

	public void setName(Fullname name) {
		this.name = name;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
