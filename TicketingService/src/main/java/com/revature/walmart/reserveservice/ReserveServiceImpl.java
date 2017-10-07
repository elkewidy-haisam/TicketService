package com.revature.walmart.reserveservice;

import java.util.List;
import java.util.Map;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;

public class ReserveServiceImpl {
	
	public void setSeatsToReserved(Venue venue, List<Seat> seats) {
		
		Map <Seat, SeatStatus> venueSeats = venue.getSeats();
		
		for (Seat seat: seats) {
			
			venueSeats.put(seat, SeatStatus.Reserved);
			
		}
		
		
	}
	
	
	

}
