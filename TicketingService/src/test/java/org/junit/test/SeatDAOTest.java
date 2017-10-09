package org.junit.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

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

/**
 * 
 * Tests the SeatDAO interface methods:
 * 
 * com.revature.walmart.dao.SeatDAO.UpdateSeatStatus(Venue venue, Seat seat)
 * 
 * 
 * @author Haisam Elkewidy
 *
 */
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
	
	/**
	 *  Tests the ability to update the status of a seat after a user has claimed it.
	 *  In this example, a seat status is changed to "Reserved", then it is verified that
	 *  the seat has become reserved. 
	 */
	@Test
	public void updateSeatStatusTest() {
		
		Seat seat = new Seat("A-1", SeatStatus.Reserved);
		
		seatdaoimpl.UpdateSeatStatus(venue, seat);
		
		Map<Seat, SeatStatus> venueSeats = venue.getSeats();
		
		assertEquals(SeatStatus.Reserved, venueSeats.get(seat));
		
	}
	
	/**
	 * Tests the ability to search for seats by a specific identifier, i.e. a seatCode,
	 * regardless of the venue in question.
	 * 
	 * In this case, the test is looking for seat A-1 in the Parthenon venue. The seat
	 * is then stored in a seat object. It is then verified that the seat code for the returned
	 * seat is, in fact, A-1.
	 */
	@Test
	public void FindSeatByCodeTest() {
		
		String seatCode = "A-1";
		Seat seat = seatdaoimpl.FindSeatsByCode(venue, seatCode);
		
		assertEquals("A-1", seat.getSeatCode());
		
		
	}
	
	

}
