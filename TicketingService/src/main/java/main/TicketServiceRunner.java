package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.revature.walmart.beans.Seat;
import com.revature.walmart.beans.SeatStatus;
import com.revature.walmart.beans.Venue;
import com.revature.walmart.ticketservice.TicketServiceImpl;

public class TicketServiceRunner {
	
	static TicketServiceImpl ticketService = new TicketServiceImpl();
	
	// list all venues available, and have a user select one
	// if it matches, display total number of seats, reserved seats, available seats, and on hold
	// decide if you want to reserve a seat, or put a seat on hold
		// if user chooses to reserve seats, select how many seats to reserve
			// allow the user to select seats based on preference (keep-it-open)
			// provide option to pay
		// if user chooses to put seats on hold before buying
			// allow the user to select seats based on preference (keep-it-open)
			// issue a warning that the seats will only be on hold for one day
	//
	
	// logic for generating a grid 
	/**
	 * 
	 * Allows a seating chart to be generated for a specific venue. Taking all the seats that are stored
	 * for a specific venue.
	 * 
	 * 
	 * 
	 * @param venue
	 */
	public static void generateSeatingGrid(Venue venue) {
		
		int rows = venue.getNumSeats()/10;
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		
		  System.out.println("------------------------------------------------[[  STAGE  ]]--------------------------------------------------");
	      System.out.println("---------------------------------------------------------------------------------------------------------------");
	 
		
		for (int i = 0; i < rows; i++) {
			
			for (int j = 1; j <= 10; j++) {
				
				switch(venue.getSeats().get(letters[i] + "-" + j)) {
				
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
	
	/**
	 *  
	 *  
	 *  Creates seat objects for a particular venue. Each seat object will have the following:
	 *  
	 *  Seat number, or code.
	 *  Seat Status - available, reserved, on hold.
	 *  
	 *  
	 * @param venue
	 * @return
	 */
	public static Map<Seat, SeatStatus> generateSeatsForVenue(Venue venue) {
		int rows = venue.getNumSeats()/10;
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		Map<String, SeatStatus> venueSeats = new HashMap<String, SeatStatus>();
		
		for (int i = 0; i < rows; i++) {
			
			for (int j = 1; j <= 10; j++) {
				
				venueSeats.put(letters[i] + "-" + j, SeatStatus.Available);
				
			}
			
		}
		
		return venueSeats;
	
	}
	
		
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Venue> venues = new ArrayList<>();
		
		Venue parthenon = new Venue();
		parthenon.setVenueName("Parthenon");
		parthenon.setNumSeats(100);
		parthenon.setAvailableSeats(100);
		parthenon.setTemporarySeats(0);
		
		
		Venue colosseum = new Venue();
		colosseum.setVenueName("Colosseum");
		colosseum.setNumSeats(200);
		colosseum.setAvailableSeats(200);
		colosseum.setTemporarySeats(0);
		
		
		Venue amphitheater = new Venue();
		amphitheater.setVenueName("Amphitheater");
		amphitheater.setAvailableSeats(200);
		amphitheater.setNumSeats(200);
		amphitheater.setTemporarySeats(0);
		
		venues.add(parthenon);
		venues.add(colosseum);
		venues.add(amphitheater);
		
		Map<Seat, SeatStatus> parthenonSeats = generateSeatsForVenue(venues.get(0));
		Map<Seat, SeatStatus> colosseumSeats = generateSeatsForVenue(venues.get(1));
		Map<Seat, SeatStatus> amphitheaterSeats = generateSeatsForVenue(venues.get(2));
		
		parthenon.setSeats(parthenonSeats);
		colosseum.setSeats(colosseumSeats);
		amphitheater.setSeats(amphitheaterSeats);
		
		System.out.println("Please enter the email you will use to make your reservation: ");
		String email = scan.nextLine();
		
		
		System.out.println("Please enter the number correlating to the available venue option: ");
		System.out.println("The options available are: ");
		
		for (int i = 0; i < venues.size(); i++) {
			
			System.out.println( (i + 1) + ": " + venues.get(i).getVenueName());
			
		}
		
		
		int input = scan.nextInt();
			
			if (input <= venues.size()) {
				
				System.out.println();
				System.out.println("The selected venue '" + venues.get(input - 1).getVenueName() + "' has " + venues.get(input).getNumSeats() + " seats total.");
				System.out.println(ticketService.numSeatsAvailable() + " of which are available.");
				System.out.println(venues.get(input - 1).getTemporarySeats() + " are on hold.");
				
			}
		
		System.out.println();
		System.out.println("Please enter A to reserve seats, or B to put seats on hold for later.");
		String decision = scan.next();
		
		while ( !decision.equals("A") & !decision.equals("B")) {
			
			System.out.println("Not a valid decision.");
			System.out.println("Please enter A to reserve seats, or B to put seats on hold for later.");
			decision = scan.nextLine();
			
		}
		
		if (decision.equals("A")) {
			
			System.out.println("Below is the seating chart for the chosen venue.");
			System.out.println("(A) - Available, (R) - Reserved, (H) - On Hold");
			System.out.println("Select among the available seats.");
		
		generateSeatingGrid(venues.get(input-1));
		
		//display seating grid here in command line
			System.out.println("Seating grid for venue will be displayed here.");
			System.out.println("Please select from available seats by typing in the seat code, followed by commas.");
		//type in available seats as strings.
			String seats = scan.next();
		
		//depending on the seat code selected, you then go to the chosen venue map and set each one to reserved.
		
		
			String seatCodes = seats.split(",");
		
		for (int seat = 0; seat < seatCodes.length; seat++) {
			
			seatCodes[seat].trim();
			
			if (venues.get(input-1).getSeats().containsKey(seatCodes[seat])) {
				
				Map<Seat, SeatStatus> updatedVenueSeatCharting = venues.get(input - 1).getSeats();
				updatedVenueSeatCharting.put(seatCodes[seat], SeatStatus.Reserved);
				venues.get(input-1).setSeats(updatedVenueSeatCharting);
				System.out.println("The selected seat " + seatCodes[seat] + " has been " + venues.get(input - 1).getSeats().get(seatCodes[seat]) );
			
			}
		}
		
		// seats have been selected
		System.out.println("Seats have been selected. Your reservation code is: " + ticketService.reserveSeats(2000, email));
		System.out.println("Current seating charge after selection has been made.");
		System.out.println(" (A) - Available, (R) - Reserved, (H) - On Hold");
		
		generateSeatingGrid(venues.get(input-1));
		
			
			
		} else if (decision.equals("B")) {
			
			
		//display seating grid here in command line
			System.out.println("Below is the seating chart for the chosen venue.");
			System.out.println("Green seats are available, red seats are already reserved, and yellow seats are on temporary hold.");
			System.out.println("Seating grid for venue will be displayed here.");
			
			generateSeatingGrid(venues.get(input));
			
			System.out.println("Please select from available seats by typing in the seat code, followed by commas.");
			
			//type in available seats as strings.
			String seats = scan.next();
			
			//depending on the seat code selected, you then go to the chosen venue map and set each one to reserved.
			
			
			String[] seatCodes = seats.split(",");
			
			for (int seat = 0; seat < seatCodes.length; seat++) {
				
				seatCodes[seat].trim();
				
				if (venues.get(input-1).getSeats().containsKey(seatCodes[seat])) {
					
					Map<String, SeatStatus> updatedVenueSeatCharting = venues.get(input - 1).getSeats();
					updatedVenueSeatCharting.put(seatCodes[seat], SeatStatus.On_Hold);
					
					System.out.println("The selected seat " + seatCodes[seat] + " has been placed " + venues.get(input - 1).getSeats().get(seatCodes[seat]) );
				
				}
			}
			
		// seats have been placed on hold
			System.out.println("Seats have been placed on hold.");
		
	    // would you like to buy the seats, you will have only 3 seconds to decide.
			System.out.println("Would you like to buy seats now? They will be on hold for 3 seconds only. Y/N.");
			
		// if bought, they become reserved
			String holdDecision = scan.next();
		
		// if not bought, they return back to available
			if (holdDecision == "Y") {
				
				System.out.println("Seats are now reserved.");
				
			} else {
				
				for (int seat = 0; seat < seatCodes.length; seat++) {
					
					if (parthenon.getSeats().containsKey(seatCodes[seat])) {
						
						venues.get(input - 1).getSeats().put(seatCodes[seat], SeatStatus.Available);
					
					}
				}
				
				System.out.println("Seats are no longer on hold. They're available again.");
				
			}
			
		}
		
	}

}
