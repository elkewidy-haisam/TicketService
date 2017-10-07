package com.revature.walmart.dao;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.Venue;

public interface SeatDAO {

	public void UpdateSeatStatus(Venue venue, Seat seat);

	public Seat FindSeatsByCode(Venue venue, String seatCode);

	public void FindSeatsByNumber(Venue venue, int seatNumber);

}
