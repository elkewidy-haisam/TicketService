package com.revature.walmart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;

public class SeatDAOImpl implements SeatDAO {

	
	public void UpdateSeatStatus(Venue venue, Seat seat) {
		
		Map<Seat, SeatStatus> seats = venue.getSeats();
		
		seats.put(seat, seat.getStatus());
		
		venue.setSeats(seats);
		
	}


	
	public Seat FindSeatsByCode(Venue venue, String seatCode) {
		// TODO Auto-generated method stub
		Map<Seat, SeatStatus> seats = venue.getSeats();
		Seat seat = new Seat();
		
		for (Seat nextSeat : seats.keySet()) {
			
			if (nextSeat.getSeatCode().equals(seatCode)) {
				
				seat = nextSeat;
				
			}
			
		}
		
		return seat;
		
		
	}


	public void FindSeatsByNumber(Venue venue, int seatNumber) {
		// TODO Auto-generated method stub
		
	}
	

}
