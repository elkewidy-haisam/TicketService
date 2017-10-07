package com.revature.walmart.exceptions;

public class DuplicateSelectionException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	static String seatCode;
	
	static String message = "You already selected the seat " + seatCode;
	
	public DuplicateSelectionException() {
		
		super(message);
		
	}
	

}
