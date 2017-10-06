package com.revature.walmart.beans;

import java.util.ArrayList;
import java.util.Map;

/**
 * 
 * Creates a Venue object with specifications pertaining to that venue. A venue typically has the following associated with it:
 * 
 * public Map<String, SeatStatus> seats: A map of seats, with the key being their seat codes in the venue, and their SeatStatus being an enumeration of either: Available, Reserved, or On Hold.
 * private int numSeats: An integer for the number of seats total inside the venue. This can be decided arbitrarily.
 * private int availableSeats: An integer for the number of seats available, excluding the seats that are on hold and those already reserved.
 * private int temporarySeats: An integer for the number of seats on hold.
 * private String venueName: a String for the name of the venue.
 * 
 * 
 * 
 * @author Admin
 *
 */
public class Venue {
	
	
	private int numSeats;

	private int availableSeats;
	
	private int temporarySeats;
	
	private String venueName;
	
	public Map<String, SeatStatus> seats;
	
	
	
	public Map<String, SeatStatus> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, SeatStatus> seats) {
		this.seats = seats;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getTemporarySeats() {
		return temporarySeats;
	}

	public void setTemporarySeats(int temporarySeats) {
		this.temporarySeats = temporarySeats;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public Venue() {
		super();
		
	}
	
	public Venue(int numSeats, String venueName, int temporarySeats) {
		super();
		this.numSeats = numSeats;
		this.venueName = venueName;
		this.temporarySeats = temporarySeats;
		this.availableSeats = numSeats - temporarySeats;
		
	}
	

}
