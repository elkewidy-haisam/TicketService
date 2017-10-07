package com.revature.walmart.exceptions;

public class AlreadyReservedException extends Exception{

	private static final long serialVersionUID = 1L;
	
		
	static String seatCode;
	
	static String message = "The seat " + seatCode + "has been reserved by another customer.";
	
	
	public AlreadyReservedException() {
		super(message);
		
	}
	
	
}
