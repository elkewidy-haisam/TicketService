package com.revature.walmart.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;

@Repository("venuedaoimpl")
public class VenueDAOImpl implements VenueDAO{
	
	SeatDAOImpl seatdaoimpl = new SeatDAOImpl();

	public void generateSeatingGrid(Venue venue) {
		// TODO Auto-generated method stub
		
		
		int rows = venue.getNumSeats()/10;
		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		
		  System.out.println("------------------------------------------------[[  STAGE  ]]--------------------------------------------------");
	      System.out.println("---------------------------------------------------------------------------------------------------------------");
	 
		
		for (int i = 0; i < rows; i++) {
			
			for (int j = 1; j <= 10; j++) {
				
				
				switch(venue.getSeats().get(seatdaoimpl.FindSeatsByCode(venue, letters[i] + "-" + j))) {
				
					case Available:
						System.out.print("[ " + letters[i] + "-" + j + " (A) ]");
						break;
					case Reserved:
						System.out.print("[ " + letters[i] + "-" + j + " (R) ]");
						break;
					case On_Hold:
						System.out.print("[ " + letters[i] + "-" + j + " (H) ]");
						break;
				
				}
		
			}
		
			System.out.println();
		}
		
	}

	
	public Map<Seat, SeatStatus> generateSeatsForVenueByCode(Venue venue) {
		int rows = venue.getNumSeats()/10;
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		Map<Seat, SeatStatus> venueSeats = new HashMap<Seat, SeatStatus>();
		
		for (int i = 0; i < rows; i++) {
			
			for (int j = 1; j <= 10; j++) {
				
				Seat seat = new Seat(letters[i] + "-" + j, SeatStatus.Available);
				venueSeats.put(seat, SeatStatus.Available);
				
			}
			
		}
		
		return venueSeats;
	}

	
	public Set<Seat> findSeatsByEmail() {
		
		Set<Seat> seatsOnHold = new HashSet<Seat>();
		
		return seatsOnHold;
		
	}
	
	
	
	
	
	
	
	

}
