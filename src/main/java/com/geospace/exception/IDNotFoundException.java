package com.geospace.exception;

/**
 * IDNotFoundException
 * This class is used to throw Exception when a particular ID is not found.
 * @author Prasad Ramalingam
 *
 */
public class IDNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5391599692244802882L;
	
	public IDNotFoundException(String message) {
		super(message);
	}


}
