package com.revature.walmart.dao;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.Venue;

public interface SeatDAO {

	void UpdateSeatStatus(Venue venue, Seat seat);

	Seat FindSeatsByCode(Venue venue, String seatCode);

	void FindSeatsByNumber(Venue venue, int seatNumber);

}
