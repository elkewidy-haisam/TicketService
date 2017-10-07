package com.revature.walmart.reserveservice;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.Venue;

@Repository
public interface ReserveService {
	
	
	public void setSeatstoReserved(Venue venue, List<Seat> seats);
	
	
	

}
