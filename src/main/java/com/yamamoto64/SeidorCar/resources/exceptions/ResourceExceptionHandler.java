package com.yamamoto64.SeidorCar.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.yamamoto64.SeidorCar.services.exceptions.RentException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(RentException.class)
	public ResponseEntity<StandardError> rentException(RentException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(), "Bad request", e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
