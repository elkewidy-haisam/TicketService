The ticket service is designed to make it easier to reserve, locate, and put seats on hold. The intention is that, for any given venue,
provided you have a map of seats available, then you can display seating charts for that venue. The charts would then allow the users to
select seats as per their preferences. The assumptions being made for this service are as follows:

1.  The preferences for seat selection are at the user's discretion, allowing him the freedom to choose whichever seats he/she wants best.

2.  The seats are individually distinguished by some sort of identifier, whether it be a number/letter combination 
    (for example, A1, A2, A3), or by a number (01, 02, 03, 04).

3.  The SeatHold object in the TicketService API has at least the following three columns: seatHoldId, numSeats, customerEmail. To indicate
	- the ID corresponding to the seat hold
	- the customer email
	- the number of seats that customer is holding

4.  All information pertaining to a venue is available in a Venue table somewhere in the TicketService database, including but not limited to:
	- number of seats in total
	- number of reserved seats
	- number of seats available
	- venue name

    However, the actual seats for that venue are stored in a Map, to allow for flexibility in identifying each seat and in the status of each one.

5.  Because the amount of time a user has to commit to held seats is only three seconds, then the user will only be able to secure one SeatHold
    at any given point in time throughout the application. Because he/she will simply not have enough time to reserve more seats and update the seatHold.

6.  The venue information is being injected as a Spring Bean into the numSeatsAvailable() method, because the method does not take any parameters.

7.  The SeatHold object probably has an id associated with it, that is generated by a sequence. Additionally, the SeatHold object is also
    created when a user reserves seats, meaning that the SeatHold object implies that these seats are inherently "held" by a user, regardless
    if they're temporarily being on hold or reserved initially. Therefore, if a seat is being placed on hold, the seatHold object will be deleted after three seconds if not chosen to commit to that.
    But if the seats are reserved, the seatHold will be placed there and remain so.

8.  A user will either choose to reserve all seats, or put all seats on hold for a given request. The user will not choose to reserve some
    seats and put other seats on hold within the same request.
	
	
	

Instructions for running application on the command line:

1. Clone the repository onto your local machine into any directory you desire.

2. The directory hierarchy of the project has two folders, one inside the other, called TicketService.
   Please go into the second TicketService folder, then you should find the following content inside that:
   
   .git
   .metadata
   .recommenders.
   RemoteSystemsTempFiles
   Servers
   TicketingService
   .gitattributes
   .gitignore
   README.md
   
   Open the command prompt window onto the directory of the TicketingService folder.
   
3. Run the tests from the command line using "mvn test". Please make sure that the directory ends with the following:

	\TicketService\TicketService\TicketingService



