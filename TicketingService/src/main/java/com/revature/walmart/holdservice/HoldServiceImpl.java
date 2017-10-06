package com.revature.walmart.holdservice;

import java.util.ArrayList;

import com.revature.walmart.beans.SeatHold;

public class HoldServiceImpl implements HoldService{

	ArrayList<SeatHold> seatsOnHold;
	
	@Override
	public SeatHold findSeatHoldByEmail(String customerEmail) {
		
		SeatHold seatHold = new SeatHold();
		
		for (int i = 0; i < seatsOnHold.size(); i++) {
			
			if (seatsOnHold.get(i).getCustomerEmail() == customerEmail) {
				
				seatHold = seatsOnHold.get(i);
				
			}
			
		}
		
		
		return seatHold;
		
	}

	@Override
	public void deleteSeatHold(SeatHold seatHold) {
		
		for (int i = 0; i < seatsOnHold.size(); i++) {
			
			if (seatsOnHold.get(i) == seatHold) {
				
				seatsOnHold.remove(i);
				
			}
			
		}
	
	}

	@Override
	public void addSeatHold(SeatHold seatHold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSeatHold(SeatHold seatHold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numSeatsAvailable() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
