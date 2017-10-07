package com.revature.walmart.exceptions;

public class AlreadyHeldException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

static String seatCode;
	
	static String message = "The seat " + seatCode + "is being temporarily held by another customer.";
	
	
	public AlreadyHeldException() {
		super(message);
		
	}

}
