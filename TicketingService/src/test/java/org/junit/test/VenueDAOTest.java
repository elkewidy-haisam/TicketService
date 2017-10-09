package org.junit.test;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;
import com.revature.walmart.config.TicketServiceConfig;
import com.revature.walmart.dao.VenueDAO;

/**
 *  
 *  Tests the VenueDAO interface methods:
 *  
 *  com.revature.walmart.dao.VenueDAO.generateSeatingGrid(Venue venue)
 *  com.revature.walmart.dao.VenueDAO.generateSeatsForVenueByCode(Venue venue)
 *  com.revature.walmart.dao.VenueDAO.findSeatsByEmail(String customerEmail)
 *  
 * @author Haisam Elkewidy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TicketServiceConfig.class)
public class VenueDAOTest {
	
	@Autowired
	@Qualifier("parthenon")
	Venue venue;
	
	@Autowired
	@Qualifier("venuedaoimpl")
	VenueDAO venuedaoimpl;
	
	@Test
	public void generateSeatingGridTest() {
		
		venuedaoimpl.generateSeatingGrid(venue);
		
		
	}
	
	@Test
	public void generateSeatsForVenueByCodeTest() {
		
		Map<Seat, SeatStatus> venueSeats = venuedaoimpl.generateSeatsForVenueByCode(venue);
		
		assertEquals(venueSeats.size(), venue.getNumSeats());
		
	}
	
	@Test
	public void findSeatsByEmailTest() {
		
		Set<Seat> seats = venuedaoimpl.findSeatsByEmail();
		
		for (Seat seat : seats) {
			
			assertEquals("elkewidyhaisam@gmail.com", seat.getPlaceholderEmail());
			
		}
		
		
	}

}
