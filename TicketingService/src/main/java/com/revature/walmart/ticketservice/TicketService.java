package com.revature.walmart.ticketservice;

import org.springframework.stereotype.Repository;

import com.revature.walmart.beans.SeatHold;

/**
 *  
 * Ticketing Service interface, required to be implemented in coding challenge.
 *  
 * Methods contained therein:
 *  
 * int numSeatsAvailable()
 * SeatHold findAndHoldSeats(int numSeats, String customerEmail)
 * String reserveSeats(int seatHoldId, String customerEmail)
 *  
 * @author Brian Massey, Walmart
 *
 */
@Repository
public interface TicketService {
	
	
	/**
	 * The number of seats in the venue that are neither held nor reserved.
	 *   
	 *  
	 * @return the number of tickets available in the venue.
	 */
	int numSeatsAvailable();
	
	
	/**
	 *  
	 * Find and hold the best available seats for a customer.
	 *  
	 *  
	 *  
	 * @param numSeats the number of seats to find and hold
	 * @param customerEmail unique identifier for the customer
	 * @return a SeatHold object identifying the specific seats and related information
	 */
	SeatHold findAndholdSeats(int numSeats, String customerEmail);
	
	
	
	/**
	 * 
	 *  Commit seats held for a specific customer.
	 * 
	 * 
	 *  @param seatHoldId the seat hold identifier
	 *  @param customerEmail the email address of the customer to which the seat hold is assigned
	 *  @return a reservation confirmation code.
	 */
	String reserveSeats(int seatHoldId, String customerEmail);
	
	

}
