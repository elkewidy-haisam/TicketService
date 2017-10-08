package com.revature.walmart.reserveservice;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.Venue;

/**
 * Service interface for handling seats that are held by customers.
 * Methods contained therein:
 * 
 * public void setSeatstoReserved(Venue venue, List<Seat> seats)
 *  
 *  
 * @author Haisam Elkewidy
 *
 */
@Repository
public interface ReserveService {
	
	
	public void setSeatstoReserved(Venue venue, List<Seat> seats);
	
	
	

}
