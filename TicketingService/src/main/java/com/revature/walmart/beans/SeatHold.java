package com.revature.walmart.beans;

import java.util.Set;

/**
 *  
 * creates a SeatHold object for every customer, containing the following:
 * 
 * int numSeats - the number of seats the customer has reserved within a specific venue
 * String customerEmail - the email the customer used to make the reservation
 *    
 * enforced with proper encapsulation to access, and mutate, the fields accordingly.   
 *      
 * @author Haisam Elkewidy
 *
 */
public class SeatHold {
	
	//this is most likely sequence generated
	private int seatHoldId;

	private int numSeats;
	
	private String customerEmail;
	
	
	public SeatHold() {
		super();
		
	}

	public SeatHold(int numSeats, String customerEmail) {
		super();
		this.numSeats = numSeats;
		this.customerEmail = customerEmail;
		
	}

	public int getNumSeats() {
		return numSeats;
		
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
		
	}

	public String getCustomerEmail() {
		return customerEmail;
		
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
		
	}
	
	
}
