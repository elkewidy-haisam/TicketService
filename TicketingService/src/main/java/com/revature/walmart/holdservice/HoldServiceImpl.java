package com.revature.walmart.holdservice;

import java.util.ArrayList;

import com.revature.walmart.beans.SeatHold;
import com.revature.walmart.beans.Venue;

public class HoldServiceImpl implements HoldService{

	ArrayList<SeatHold> seatsOnHold;
	
	@Override
	public SeatHold findSeatHoldByEmail(String customerEmail) {
		
		SeatHold seatHold = new SeatHold();
		
		for (int i = 0; i < seatsOnHold.size(); i++) {
			
			if (seatsOnHold.get(i).getCustomerEmail() == customerEmail) {
				
				seatHold = seatsOnHold.get(i);
				
			}
			
		}
		
		
		return seatHold;
		
	}
	
	@Override
	public ArrayList<SeatHold> findSeatHoldsByVenue(Venue venue) {
		
		ArrayList<SeatHold> seatsOnHold = venue.getSeatsOnHold();
		
		return seatsOnHold;
		
	}

	@Override
	public void deleteSeatHold(Venue venue, SeatHold seatHold) {
		
		ArrayList<SeatHold> seatsOnHold = venue.getSeatsOnHold();
		
		for (int i = 0; i < seatsOnHold.size(); i++) {
			
			if (seatsOnHold.get(i) == seatHold) {
				
				seatsOnHold.remove(i);
				
			}
			
		}
	
	}

	@Override
	public void addSeatHold(SeatHold seatHold) {
		// TODO Auto-generated method stub
		
		seatsOnHold.add(seatHold);
		
	}

}
