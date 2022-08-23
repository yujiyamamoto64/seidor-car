package com.yamamoto64.SeidorCar.services.exceptions;

public class RentException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RentException(String msg) {
		super(msg);
	}
	
	public RentException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
