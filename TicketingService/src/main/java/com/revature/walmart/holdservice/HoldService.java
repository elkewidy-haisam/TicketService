package com.revature.walmart.holdservice;

import com.revature.walmart.beans.SeatHold;
import com.revature.walmart.ticketservice.TicketService;

public interface HoldService{
	
	public SeatHold findSeatHoldByEmail(String customerEmail);
	
	public void deleteSeatHold(SeatHold seatHold);
	
	public void addSeatHold(SeatHold seatHold);
	
	public void updateSeatHold(SeatHold seatHold);

}
