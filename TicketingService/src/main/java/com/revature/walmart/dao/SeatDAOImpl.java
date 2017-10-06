package com.revature.walmart.dao;

import java.util.Map;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;

public class SeatDAOImpl implements SeatDAO {

	Venue venue;
	
	
	@Override
	public void UpdateSeatStatus(Seat seat) {
		
		Map<String, SeatStatus> seats = venue.getSeats();
		
		seats.put(seat.getSeatCode(), seat.getStatus());
		
		venue.setSeats(seats);
		
	}
	
	
	
	

}
