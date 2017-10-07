package com.revature.walmart.ticketservice;

import com.revature.walmart.beans.SeatHold;
import com.revature.walmart.beans.Venue;

/**
 *  
 * Implements the TicketService interface methods:
 * 
 * int numSeatsAvailable(Venue venue)
 * SeatHold findAndHoldSeats(int numSeats, String customerEmail) 
 * String reserveSeats(int seatHoldId, String customerEmail) 
 *  
 * @author Admin
 *
 */
public class TicketServiceImpl implements TicketService{

	
	Venue venue = new Venue();
	
	
	public int numSeatsAvailable() {
		// TODO Auto-generated method stub
		
		int availableSeats = venue.getAvailableSeats();
		
		return availableSeats;
	}

	
	public SeatHold findAndholdSeats(int numSeats, String customerEmail) {
		// TODO Auto-generated method stub
		
		SeatHold seatHold = new SeatHold();
		seatHold.setCustomerEmail(customerEmail);
		seatHold.setNumSeats(numSeats);
		
		return seatHold;
		
	}

	
	public String reserveSeats(int seatHoldId, String customerEmail) {
		
		// you will want to find a way to generate confirmation codes automatically with every reservation that's made...
		return "Reservation confirmation code: " + customerEmail.substring(0, 5) + "@" + seatHoldId;
		
	}

}
