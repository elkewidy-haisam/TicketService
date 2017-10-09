package com.revature.walmart.beans;

/**
 * 
 * Creates a Seat object containing information pertaining to a specific seat inside a venue.
 * 
 * @param String seatCode - a code to identify the seat, usually comprised of a letter and a number.
 * @param int seatNumber - a number to identify the seat, in case the venue's seats are defined only by number
 * @param placeholderEmail - this is the customer's email, the one used to reserve, or hold, the seat in question
 * @param SeatStatus status - the status of the seat; can be either 1) available, 2) reserved, 3) on hold
 * 
 * @author Haisam Elkewidy
 *
 */
public class Seat {
	
	private String seatCode;
	private int seatNumber;
	private String placeholderEmail;
	
	private SeatStatus status;
	
	
	public Seat() {
		
		
		
	}
	
	public Seat(int seatNumber, SeatStatus status) {
		super();
		this.seatNumber = seatNumber;
		this.status = status;
	}

	public Seat(String seatCode, SeatStatus status) {
		super();
		this.seatCode = seatCode;
		this.status = status;
	}

	public Seat(String seatCode, int seatNumber, SeatStatus status) {
		super();
		this.seatCode = seatCode;
		this.seatNumber = seatNumber;
		this.status = status;
	}

	public String getSeatCode() {
		return seatCode;
	}

	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}

	public String getPlaceholderEmail() {
		return placeholderEmail;
	}

	public void setPlaceholderEmail(String placeholderEmail) {
		this.placeholderEmail = placeholderEmail;
	}	
	
	

}
