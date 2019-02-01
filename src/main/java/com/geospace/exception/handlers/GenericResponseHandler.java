package com.geospace.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.geospace.exception.IDNotFoundException;
import com.geospace.exception.NameFormatException;
import com.geospace.models.ErrorMessage;
/**
 * GenericResponseHandler
 * This class is used to provide a proper support for Exception Response.
 * @author Prasad Ramalingam
 *
 */
@RestControllerAdvice
public class GenericResponseHandler {

	@ExceptionHandler(value = { NameFormatException.class, IDNotFoundException.class })
	public ResponseEntity<ErrorMessage> handleNameFormatException(NameFormatException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}