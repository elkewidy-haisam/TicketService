package com.revature.walmart.holdservice;

import java.util.ArrayList;

import com.revature.walmart.beans.SeatHold;
import com.revature.walmart.beans.Venue;

public interface HoldService{
	
	public SeatHold findSeatHoldByEmail(String customerEmail);
	
	public void deleteSeatHold(Venue venue, SeatHold seatHold);
	
	public ArrayList<SeatHold> findSeatHoldsByVenue(Venue venue);
	
	public void addSeatHold(SeatHold seatHold);

}
