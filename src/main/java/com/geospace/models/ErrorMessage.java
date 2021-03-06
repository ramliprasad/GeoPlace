package com.geospace.models;

/**
 * ErrorMessage
 * This class is used for passing error messages onto response 
 * @author Prasad Ramalingam
 *
 */
public class ErrorMessage {
	
	private String message;
	private int status;
	
	public ErrorMessage(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
