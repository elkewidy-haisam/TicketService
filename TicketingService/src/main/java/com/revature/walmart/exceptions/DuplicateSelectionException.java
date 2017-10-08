package com.revature.walmart.exceptions;

/**
 *  
 *  Exception to indicate that a particular seat in a venue, identified by
 *  a number or some code, has already been selected by the user beforehand.
 *  
 * @author Haisam Elkewidy
 *
 */
public class DuplicateSelectionException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicateSelectionException(String message) {
		
		super(message);
		
	}
	

}
