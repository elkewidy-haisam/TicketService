package com.revature.walmart.ticketservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
@Repository("ticketserviceimpl")
public class TicketServiceImpl implements TicketService{

	@Autowired
	@Qualifier("colosseum")
	Venue venueOne;
	
	@Autowired
	@Qualifier("parthenon")
	Venue venueTwo;
	
	@Autowired
	@Qualifier("amphitheater")
	Venue venueThree;
	
	
	public int numSeatsAvailable() {
		// TODO Auto-generated method stub
		
		int availableSeats = venueOne.getAvailableSeats();
		
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
