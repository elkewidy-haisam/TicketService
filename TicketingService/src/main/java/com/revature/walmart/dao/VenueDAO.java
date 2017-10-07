package com.revature.walmart.dao;

import java.util.Map;
import java.util.Set;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;

public interface VenueDAO {
	
	public Map<Seat, SeatStatus> generateSeatingGrid();
	
	public Map<Seat, SeatStatus> generateSeatsForVenueByCode(Venue venue);
	
	public Set<Seat> findSeatsByEmail();
	

}
