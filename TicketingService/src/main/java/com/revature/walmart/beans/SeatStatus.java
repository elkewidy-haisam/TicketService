package com.revature.walmart.beans;

import java.io.Serializable;

/**
 * 
 * Enumeration to determine the status of a seat inside the venue. It can be one of the following three categories:
 * 
 * Available: means that the seat is available for reserving.
 * Reserved: means that the seat is already reserved by someone, and cannot be reserved anymore.
 * On Hold: means that someone is currently putting it on hold, and may decide to reserve the seats after three seconds.
 * 
 * 
 */
public enum SeatStatus implements Serializable{
	
	Available,
	Reserved,
	On_Hold
	

}
