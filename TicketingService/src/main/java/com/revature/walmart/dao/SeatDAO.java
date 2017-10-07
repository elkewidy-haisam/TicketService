package com.revature.walmart.dao;

import org.springframework.stereotype.Repository;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.Venue;

@Repository
public interface SeatDAO {

	public void UpdateSeatStatus(Venue venue, Seat seat);

	public Seat FindSeatsByCode(Venue venue, String seatCode);

	public void FindSeatsByNumber(Venue venue, int seatNumber);
	
	

}
