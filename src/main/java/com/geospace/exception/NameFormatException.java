package com.geospace.exception;

/**
 * NameFormatException This class is used to throw Exception when the name
 * format is not proper. By default a name should have both first name and last
 * name. 
 * 
 * It should be of the following format "name": "Prasad Ramalingam"
 * 
 * @author Prasad Ramalingam
 *
 */
public class NameFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1882847276200540425L;

	public NameFormatException(String message) {
		super(message);
	}

}
