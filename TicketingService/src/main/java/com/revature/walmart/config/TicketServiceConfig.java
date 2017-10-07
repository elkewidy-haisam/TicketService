package com.revature.walmart.config;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.commons.dbcp.BasicDataSource;

import com.revature.walmart.beans.*;
import com.revature.walmart.dao.*;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.revature.walmart."})
public class TicketServiceConfig {
		
		@Autowired
		@Qualifier("venuedaoimpl")
		VenueDAO venuedaoimpl;
	
		//Spring Beans
		
		
		//1. Venues
		@Bean
		@Qualifier("parthenon")
		public Venue Parthenon() {
			
			Venue parthenon = new Venue();
			
			parthenon.setVenueName("Parthenon");
			parthenon.setNumSeats(100);
			parthenon.setAvailableSeats(100);
			parthenon.setTemporarySeats(0);
			
			Map<Seat, SeatStatus> parthenonSeats = venuedaoimpl.generateSeatsForVenueByCode(parthenon);
			parthenon.setSeats(parthenonSeats);
			
			ArrayList<SeatHold> seatsOnHold = new ArrayList<SeatHold>();
			seatsOnHold.add(new SeatHold(5, "elkewidyhaisam@gmail.com"));
			
			parthenon.setSeatsOnHold(seatsOnHold);
			
			return parthenon;
			
		}
		
		@Bean
		@Qualifier("amphitheater")
		public Venue Amphitheater() {
			
			Venue amphitheater = new Venue();
			amphitheater.setVenueName("Amphitheater");
			amphitheater.setAvailableSeats(200);
			amphitheater.setNumSeats(200);
			amphitheater.setTemporarySeats(0);
			
			Map<Seat, SeatStatus> amphitheaterSeats = venuedaoimpl.generateSeatsForVenueByCode(amphitheater);
			amphitheater.setSeats(amphitheaterSeats);
			
			return amphitheater;
			
		}
		
		@Bean
		@Qualifier("colosseum")
		public Venue Colosseum() {
			
			Venue colosseum = new Venue();
			
			colosseum.setVenueName("Colosseum");
			colosseum.setNumSeats(200);
			colosseum.setAvailableSeats(200);
			colosseum.setTemporarySeats(0);
			
			Map<Seat, SeatStatus> colosseumSeats = venuedaoimpl.generateSeatsForVenueByCode(colosseum);
			
			colosseum.setSeats(colosseumSeats);
			
			return colosseum;
			
		}
		
		//2. SeatHolds
		
		@Bean
		@Qualifier("seatHold")
		public SeatHold seatHold() {
			
			SeatHold seatHold = new SeatHold();
			seatHold.setCustomerEmail("elkewidyhaisam@gmail.com");
			seatHold.setNumSeats(5);
			
			return seatHold;
			
		}
		
		
}
