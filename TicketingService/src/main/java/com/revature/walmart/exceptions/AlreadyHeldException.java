package com.revature.walmart.exceptions;

/**
 * 
 * Exception to indicate that a seat a user is trying to reserve, or put on hold,
 * is already held by another customer.
 * 
 * 
 * @author Haisam Elkewidy
 *
 */
public class AlreadyHeldException extends Exception{
	

	private static final long serialVersionUID = 1L;

static String seatCode;
	
	static String message = "The seat " + seatCode + "is being temporarily held by another customer.";
	
	
	public AlreadyHeldException() {
		super(message);
		
	}

}
