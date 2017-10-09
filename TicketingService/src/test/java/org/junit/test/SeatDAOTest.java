package org.junit.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatHold;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;
import com.revature.walmart.config.TicketServiceConfig;
import com.revature.walmart.dao.SeatDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TicketServiceConfig.class)
public class SeatDAOTest {
	
	@Autowired
	@Qualifier("seatdaoimpl")
	SeatDAO seatdaoimpl;
	
	@Qualifier("seatHold")
	SeatHold seatHold;
	
	@Autowired
	@Qualifier("parthenon")
	Venue venue;
	
	@Test
	public void updateSeatStatusTest() {
		
		Seat seat = new Seat("A-1", SeatStatus.Reserved);
		
		seatdaoimpl.UpdateSeatStatus(venue, seat);
		
		Map<Seat, SeatStatus> venueSeats = venue.getSeats();
		
		assertEquals(SeatStatus.Reserved, venueSeats.get(seat));
		
	}
	
	@Test
	public void FindSeatByCodeTest() {
		
		String seatCode = "A-1";
		Seat seat = seatdaoimpl.FindSeatsByCode(venue, seatCode);
		
		assertEquals("A-1", seat.getSeatCode());
		
		
	}
	
	

}
