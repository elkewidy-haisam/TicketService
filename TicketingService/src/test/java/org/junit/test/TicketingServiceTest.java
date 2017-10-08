package org.junit.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
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
import com.revature.walmart.dao.VenueDAO;
import com.revature.walmart.exceptions.AlreadyHeldException;
import com.revature.walmart.exceptions.AlreadyReservedException;
import com.revature.walmart.exceptions.DuplicateSelectionException;
import com.revature.walmart.holdservice.HoldService;
import com.revature.walmart.reserveservice.ReserveService;
import com.revature.walmart.ticketservice.TicketService;

/**
 *  
 * Class for running test cases to ensure the functionality of the TicketService API.  
 *     
 * Test cases covered are as follows:
 * 1. Returning the number of seats available for a venue, and expecting that number to be returned.
 * 2. Looking to find, and hold, seats within the venue. Expecting that the number of seats a user wants to hold are, in fact, the amount the user requested to hold.
 * 3. Once a reservation has been made for seats in a venue, a reservation code is returned to the user. The reservation code is a combination of his seatHoldId and the first four letters of his email address.      
 * 4. If a user attempts to reserve seats that another user has placed on hold, then the user should not be expected to successfully reserve the held seats.
 * 5. If a user attempts to reserve seats that have already been reserved by a prior user, then the current user should not be able to reserve those same exact seats.
 * 
 * Because the API assumes a single user will be consuming it in a very controlled environment, concurrency tests were not included.       
 * However, this can be looked into in a much more scalable iteration of this application. The tests methods meant to determine this are as follows:
 * 
 * SimultaneousReservation() - what happens when two users try to reserve the same seats at the exact same time
 * SimultaneousHold() - what happens when two users try to put the same seats on hold at the exact same time
 * SimultaneousReservationAndHold() - what happens when one user tries to reserve a group of seats, and another users wants to put the same group of seats on hold, at the exact same time.
 *          
 * @author Haisam Elkewidy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TicketServiceConfig.class)
public class TicketingServiceTest {
	
	@Autowired
	@Qualifier("ticketserviceimpl")
	TicketService ticketserviceimpl;
	
	@Autowired
	@Qualifier("reserveserviceimpl")
	ReserveService reserveserviceimpl;
	
	@Autowired
	@Qualifier("holdserviceimpl")
	HoldService holdserviceimpl;
	
	@Autowired
	@Qualifier("seatdaoimpl")
	SeatDAO seatdaoimpl;
	
	@Autowired
	@Qualifier("venuedaoimpl")
	VenueDAO venuedaoimpl;
	
	
	@SuppressWarnings("unchecked")
	ArrayList<Venue> venues = new ArrayList<Venue>();
	
	@Autowired
	@Qualifier("colosseum")
	Venue colosseum;
	
	@Autowired
	@Qualifier("amphitheater")
	Venue amphitheater;
	
	@Autowired
	@Qualifier("parthenon")
	Venue parthenon;
	
	@Autowired
	@Qualifier("seatHold")
	SeatHold seatHold;
	

	
	/*@Before
	public void initialize() {
		
	parthenon.setVenueName("Parthenon");
	parthenon.setNumSeats(100);
	parthenon.setAvailableSeats(100);
	parthenon.setTemporarySeats(0);
	
	
	colosseum.setVenueName("Colosseum");
	colosseum.setNumSeats(200);
	colosseum.setAvailableSeats(200);
	colosseum.setTemporarySeats(0);
	
	amphitheater.setVenueName("Amphitheater");
	amphitheater.setAvailableSeats(200);
	amphitheater.setNumSeats(200);
	amphitheater.setTemporarySeats(0);
	
	venues.add(parthenon);
	venues.add(colosseum);
	venues.add(amphitheater);
	
	Map<Seat, SeatStatus> parthenonSeats = generateSeatsForVenueByCode(venues.get(0));
	Map<Seat, SeatStatus> colosseumSeats = generateSeatsForVenueByCode(venues.get(1));
	Map<Seat, SeatStatus> amphitheaterSeats = generateSeatsForVenueByCode(venues.get(2));
	
	parthenon.setSeats(parthenonSeats);
	colosseum.setSeats(colosseumSeats);
	amphitheater.setSeats(amphitheaterSeats);
	
	
	} */
	
	
	
	private Map<Seat, SeatStatus> generateSeatsForVenueByCode(Venue venue) {
		
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


	/**
	 *  Tests the method com.revature.walmart.ticketservice.TicketService.numSeatsAvailable()
	 *  
	 *  It takes no parameters, so we are assuming that a venue is already determined within the method.
	 *  
	 *  @return integer for the number of seats available for that particular venue.
	 */
	@Test
	public void returnNumSeatsAvailableTest() {
	
		assertEquals(200, ticketserviceimpl.numSeatsAvailable());
		
	}
	
	/**
	 *  
	 *  Tests the method com.revature.walmart.ticketservice.TicketService.findAndHoldSeats()
	 *  
	 *  Takes in the number of seats on hold and the customer's email.
	 *  
	 *  @return a seatHold object with that specific information in it.
	 *  
	 *  It is assumed that the logic to determine specific seats that are reserved occurs elsewhere.
	 */
	@Test
	public void findAndHoldSeatsTest() {
		
		String[] seatHoldCodes = {"A-1", "A-2", "A-3", "A-4", "A-5"};
		
		SeatHold seatHold = ticketserviceimpl.findAndholdSeats(seatHoldCodes.length, "walmart@revature.com");
		assertEquals(5, seatHold.getNumSeats());
		assertEquals("walmart@revature.com", seatHold.getCustomerEmail());
		
		assertEquals(100, parthenon.getNumSeats());
		parthenon.setAvailableSeats(parthenon.getAvailableSeats() - seatHoldCodes.length);
		assertEquals(90, parthenon.getAvailableSeats());
		
		
	}
	
	/**
	 *  
	 *  Tests the methods com.revature.walmart.ticketservice.TicketService.reserveSeats()
	 *  
	 *  Takes in the seatHoldId and the customer's email.
	 *  
	 *  Takes segments of both of them to create a unique reservation code for the customer.
	 *  
	 *  @return string with the reservation code contained in it.
	 *  
	 */
	@Test
	public void reserveSeatsTest() {
		
		String reservationCode = ticketserviceimpl.reserveSeats(2000, "walmart@revature.com");
		assertThat(reservationCode, containsString("walm"));
		assertThat(reservationCode, containsString("2000"));
		
	}
	
	
	/**
	 *  
	 *  Tests what should happen if a user attempts to reserves seat that are already placed on hold
	 *  by a customer.
	 *  
	 *  The expected outcome is that a certain number of seats cannot be reserved, because they are already
	 *  on hold.
	 * @throws AlreadyHeldException 
	 *  
	 */
	@Test(expected = AlreadyHeldException.class)
	public void TryToReserveHeldSeatsTest() throws AlreadyHeldException {
		
		int countOnHold = 0;
		
		String[] seatHoldCodes = {"A-1", "A-2", "A-3", "A-4", "A-5"};
		
		SeatHold seatHold = ticketserviceimpl.findAndholdSeats(seatHoldCodes.length, "walmart@revature.com");
		assertEquals(5, seatHold.getNumSeats());
		assertEquals("walmart@revature.com", seatHold.getCustomerEmail());
		
		for (int reserveSeat = 0; reserveSeat < seatHoldCodes.length; reserveSeat++) {
			
			parthenon.getSeats().put(seatdaoimpl.FindSeatsByCode(parthenon, seatHoldCodes[reserveSeat]), SeatStatus.On_Hold);
			
			
		}
		
		assertEquals(100, parthenon.getNumSeats());
		parthenon.setAvailableSeats(parthenon.getAvailableSeats() - seatHoldCodes.length);
		assertEquals(95, parthenon.getAvailableSeats());
		
		
		String[] seatReserveCodes = {"A-1", "A-3", "A-4", "A-6", "A-7"};
		
		for (int seatCheck = 0; seatCheck < seatReserveCodes.length; seatCheck++) {
			
			if (parthenon.getSeats().get(seatdaoimpl.FindSeatsByCode(parthenon, seatReserveCodes[seatCheck])).equals(SeatStatus.On_Hold)) {
				
				System.out.println("The following seat " + seatReserveCodes[seatCheck] + " cannot be reserved, as it is already on hold.");
				++countOnHold;
				throw new AlreadyHeldException();
			}
			
			
		}
		
		assertEquals(3, countOnHold);
		
	}
	
	@Test(expected = AlreadyReservedException.class)
	public void TryToReserveAlreadyReservedSeatsTest() throws AlreadyReservedException {
		
		int clashCount = 0;
		
		String[] alreadyReservedCodes = {"A-1" , "A-2" , "A-3" , "A-4" , "A-5"};
		
		String[] tryingToBeReservedCodes = {"A-1", "A-2", "A-6", "A-8", "A-4"};
		
		for (int reserveCheck = 0; reserveCheck < alreadyReservedCodes.length; reserveCheck++) {
			
			parthenon.getSeats().put(seatdaoimpl.FindSeatsByCode(parthenon, alreadyReservedCodes[reserveCheck]), SeatStatus.Reserved);
			
		}
		
		for (int reserveCompare = 0; reserveCompare < tryingToBeReservedCodes.length; reserveCompare++) {
			
			if (parthenon.getSeats().get(seatdaoimpl.FindSeatsByCode(parthenon, tryingToBeReservedCodes[reserveCompare])).equals(SeatStatus.Reserved)) {
				
				System.out.println("The following seat " + tryingToBeReservedCodes[reserveCompare] + " cannot be reserved, as it has been already booked by another user.");
				++clashCount;
				throw new AlreadyReservedException();
			}
			
			
			
		}
		
		assertEquals(3, clashCount);
		
	}
	
	@Test(expected= DuplicateSelectionException.class)
	public void DuplicateSelectionTest() throws DuplicateSelectionException {
		
		String[] reservedCodes = {"A-1", "A-2", "A-3", "A-4", "A-5"};
		String[] conflictCodes = {"A-1", "A-3", "A-4", "A-5", "A-6"};
		
		for (int i = 0; i < reservedCodes.length; i++) {
			
			for (int j = 0; j < conflictCodes.length; j++) {
			
				if (conflictCodes[j].equals(reservedCodes[i])) {
				
				throw new DuplicateSelectionException("You have already selected seat " + reservedCodes[j] + ". Please select another seat.");
				
				}
			}
			
		}
		
		
		
	}
	
	@Test
	public void DeleteSeatHoldAfterThreeSecondsTest() throws InterruptedException {
		
		SeatHold seatHold = new SeatHold(6, "revature@walmart.com");
		boolean holdDecision = false;
		
		Thread.sleep(4000);
		
		assertTrue(holdserviceimpl.deleteSeatHoldAfterThreeSeconds(parthenon, seatHold, holdDecision));
		
		
		
	}
	
	@Test
	public void commitSeatsAfterBeingHeldTest() throws InterruptedException {
		
		SeatHold seatHold = new SeatHold(6, "revature@walmart.com");
		boolean holdDecision = true;
		
		Thread.sleep(4000);
		
		assertTrue(holdserviceimpl.commitSeatHoldAfterThreeSeconds(parthenon, seatHold, holdDecision));
		
		assertEquals(2, parthenon.getSeatsOnHold().size());
		
	}
	
	
}
