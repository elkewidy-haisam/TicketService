package com.revature.walmart.dao;

import java.util.Map;
import java.util.Set;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;

public interface VenueDAO {
	
	
	public Map<Seat, SeatStatus> generateSeatingGrid();
	
	public Map<String, SeatStatus> generateSeatsForVenue();
	
	public Set<Seat> findSeatsByEmail();
	

}
