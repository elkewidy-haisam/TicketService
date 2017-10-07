package com.revature.walmart.beans;


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
