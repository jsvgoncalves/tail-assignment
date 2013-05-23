package test;

import org.junit.Test;
import static org.junit.Assert.*;

import util.TimeHelper;

import controller.Airport;
import controller.Flight;
import controller.TailContainer;

public class TailContainerTest {

	@Test
	public void sortTest(){
		TailContainer<Flight> flights = new TailContainer<Flight>();
		
		Airport ap1 = new Airport("OPO", 10, 10, 15, 15);
		Airport ap2 = new Airport("FNC", 15, 15, 17, 17);
		Airport ap3 = new Airport("LIS", 13, 13, 18, 18);
		int t1 = 0;
		int t2 = 0;
		int t3 = 0;
		int t4 = 0;
		int t5 = 0;
		int t6 = 0;
		
		try {
			t1 = TimeHelper.getMinutes("2013-05-01 06:00");
			t2 = TimeHelper.getMinutes("2013-05-01 06:30");
			t3 = TimeHelper.getMinutes("2013-05-01 07:00");
			t4 = TimeHelper.getMinutes("2013-05-01 07:30");
			t5 = TimeHelper.getMinutes("2013-05-01 08:00");
			t6 = TimeHelper.getMinutes("2013-05-01 08:30");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		// *********************** (fNum Dept Arrv Type -Times- -----Seats-------)  
		Flight flight1 = new Flight(1375, ap1, ap2, 200, t1, t2, 10, 100, 10, 100);
		Flight flight2 = new Flight(1376, ap2, ap3, 200, t3, t4, 10, 100, 10, 100);
		Flight flight3 = new Flight(1377, ap1, ap3, 200, t1, t4, 10, 100, 10, 100);
		Flight flight4 = new Flight(1378, ap3, ap1, 200, t5, t6, 10, 100, 10, 100);
		
		flights.addRecord(flight1);
		flights.addRecord(flight2);
		flights.addRecord(flight3);
		flights.addRecord(flight4);
		
		flights.sort();
		
		assertEquals(1375, flights.get(0).getNumber());
		assertEquals(1377, flights.get(1).getNumber());
		assertEquals(1376, flights.get(2).getNumber());
		assertEquals(1378, flights.get(3).getNumber());
	}
}
