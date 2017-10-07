package com.revature.walmart.reserveservice;

import java.util.List;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.Venue;

public interface ReserveService {
	
	
	public void setSeatstoReserved(Venue venue, List<Seat> seats);
	
	
	

}
