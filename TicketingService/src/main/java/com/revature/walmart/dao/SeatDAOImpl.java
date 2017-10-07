package com.revature.walmart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;

public class SeatDAOImpl implements SeatDAO {

	
	
	@Override
	public void UpdateSeatStatus(Venue venue, Seat seat) {
		
		Map<Seat, SeatStatus> seats = venue.getSeats();
		
		seats.put(seat, seat.getStatus());
		
		venue.setSeats(seats);
		
	}


	@Override
	public Seat FindSeatsByCode(Venue venue, String seatCode) {
		// TODO Auto-generated method stub
		Map<Seat, SeatStatus> seats = venue.getSeats();
		List<Seat> l = new ArrayList<Seat>(seats.keySet());
		Seat seat = new Seat();
		
		for (Seat nextSeat : l) {
			
			if (seat.getSeatCode().equals(seatCode)) {
				
				// get the seat key only from the map
				
			}
			
		}
		
		return seat;
		
		
	}


	@Override
	public void FindSeatsByNumber(Venue venue, int seatNumber) {
		// TODO Auto-generated method stub
		
	}
	

}
