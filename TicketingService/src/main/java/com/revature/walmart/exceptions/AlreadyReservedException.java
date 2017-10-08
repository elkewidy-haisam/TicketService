package com.revature.walmart.exceptions;

/**
 * 
 * Exception to indicate that a seat a user is trying to reserve, or put on hold,
 * is already reserved by another customer.
 * 
 * @author Haisam Elkewidy
 *
 */
public class AlreadyReservedException extends Exception{

	private static final long serialVersionUID = 1L;
	
		
	static String seatCode;
	
	static String message = "The seat " + seatCode + "has been reserved by another customer.";
	
	
	public AlreadyReservedException() {
		super(message);
		
	}
	
	
}
