package com.revature.walmart.reserveservice;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;

@Repository("reserveserviceimpl")
public class ReserveServiceImpl implements ReserveService{
	
	public void setSeatstoReserved(Venue venue, List<Seat> seats) {
		
		Map <Seat, SeatStatus> venueSeats = venue.getSeats();
		
		for (Seat seat: seats) {
			
			venueSeats.put(seat, SeatStatus.Reserved);
			
		}
		
		
	}
	

}
