package com.revature.walmart.holdservice;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.revature.walmart.beans.SeatHold;
import com.revature.walmart.beans.Venue;

@Repository
public interface HoldService{
	
	public SeatHold findSeatHoldByEmail(String customerEmail);
	
	public boolean deleteSeatHoldAfterThreeSeconds(Venue venue, SeatHold seatHold, boolean holdDecision);
	
	public boolean commitSeatHoldAfterThreeSeconds(Venue venue, SeatHold seatHold, boolean holdDecision);
	
	public ArrayList<SeatHold> findSeatHoldsByVenue(Venue venue);
	
	public void addSeatHold(SeatHold seatHold);

}
