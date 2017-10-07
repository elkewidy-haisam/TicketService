package com.revature.walmart.holdservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.revature.walmart.beans.SeatHold;
import com.revature.walmart.beans.Venue;

@Repository("holdserviceimpl")
public class HoldServiceImpl implements HoldService{

	@Autowired
	@Qualifier("parthenon")
	Venue venue;
	
	
	public SeatHold findSeatHoldByEmail(String customerEmail) {
		
		SeatHold seatHold = new SeatHold();
		
		for (int i = 0; i < venue.getSeatsOnHold().size(); i++) {
			
			if (venue.getSeatsOnHold().get(i).getCustomerEmail() == customerEmail) {
				
				seatHold = venue.getSeatsOnHold().get(i);
				
			}
			
		}
		
		
		return seatHold;
		
	}
	
	
	public ArrayList<SeatHold> findSeatHoldsByVenue(Venue venue) {
		
		ArrayList<SeatHold> seatsOnHold = venue.getSeatsOnHold();
		
		return seatsOnHold;
		
	}

	
	public void deleteSeatHold(Venue venue, SeatHold seatHold) {
		
		ArrayList<SeatHold> seatsOnHold = venue.getSeatsOnHold();
		
		for (int i = 0; i < seatsOnHold.size(); i++) {
			
			if (seatsOnHold.get(i) == seatHold) {
				
				seatsOnHold.remove(i);
				
			}
			
		}
	
	}

	
	public void addSeatHold(SeatHold seatHold) {
		// TODO Auto-generated method stub
		
		venue.getSeatsOnHold().add(seatHold);
		
	}

}
