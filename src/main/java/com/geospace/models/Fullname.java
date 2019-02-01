package com.geospace.models;

import javax.persistence.Embeddable;
/**
 * Fullname
 * An value class used to store and retrieve fullname as firstname and lastname.
 * @author Prasad Ramalingam
 *
 */
@Embeddable
public class Fullname {
	
	private String firstName;
	private String lastName;
	
	public Fullname() {
		super();
	}

	// JSON uses this constructor to deserialize data
	public Fullname(String name) {
		super();
		String[] tempName = name.split(" ");
		
		if(tempName.length == 2) {
			this.firstName = tempName[0];
			this.lastName = tempName[1];
		}else {
			this.firstName = "";
			this.lastName ="";
		}
		
	}
	
	public Fullname(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return this.firstName.toString() + " " + this.lastName.toString();
	}

}
