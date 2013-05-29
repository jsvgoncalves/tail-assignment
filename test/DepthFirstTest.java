package test;

import static org.junit.Assert.*;
import logic.DepthFirst;

import org.junit.Before;
import org.junit.Test;

import util.TimeHelper;
import controller.Airport;
import controller.FileLoader;
import controller.Flight;
import controller.Plane;
import controller.TailContainer;

public class DepthFirstTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPass(){
		Plane plane1 = new Plane("AAA", "Maria Joana", "200");
		Plane plane2 = new Plane("BBB", "Manuel Joaquim", "200");
		Airport ap1 = new Airport("OPO", 10, 10, 15, 15);
		Airport ap2 = new Airport("LIS", 13, 13, 18, 18);
		Airport ap3 = new Airport("FNC", 15, 15, 17, 17);
		int t1 = 0;
		int t2 = 0;
		int t3 = 0;
		int t4 = 0;
		int t5 = 0;
		int t6 = 0;
		
		try {
			t1 = TimeHelper.getMinutes("05/21/2013 06:00");
			t2 = TimeHelper.getMinutes("05/21/2013 06:30");
			t3 = TimeHelper.getMinutes("05/21/2013 07:00");
			t4 = TimeHelper.getMinutes("05/21/2013 07:30");
			t5 = TimeHelper.getMinutes("05/21/2013 08:00");
			t6 = TimeHelper.getMinutes("05/21/2013 08:30");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Flight flight1 = new Flight(1375, ap1, ap2, 200, t1, t2, 10, 100, 10, 100);
		Flight flight2 = new Flight(1376, ap2, ap3, 200, t3, t4, 10, 100, 10, 100);
		Flight flight3 = new Flight(1377, ap1, ap3, 200, t1, t4, 10, 100, 10, 100);
		Flight flight4 = new Flight(1378, ap3, ap1, 200, t5, t6, 10, 100, 10, 100);
		
		TailContainer<Flight> flights = new TailContainer<>();
		flights.addRecord(flight1);
		flights.addRecord(flight2);
		flights.addRecord(flight3);
		flights.addRecord(flight4);
		TailContainer<Plane> planes = new TailContainer<>();
		planes.addRecord(plane1);
		planes.addRecord(plane2);
		
		
		DepthFirst df = new DepthFirst(flights, planes);
		
		// The algorithm has a solution 
		assertTrue("DF falhou", df.run());
		
		// Check that the current flights assigned to all the planes
		// is equal to the total number of flights
		int numFlights = 0;
//		System.out.println(planes.getRecords().size());
		for (Plane plane : planes.getRecords()) {
			numFlights += plane.getSchedule().size();
//			System.out.println("numFlights" + numFlights);
		}
		
		assertEquals(flights.size(), numFlights);
	}
	
	
	@Test
	public void testFail(){
		Plane plane1 = new Plane("AAA", "Maria Joana", "200");
		Plane plane2 = new Plane("BBB", "Manuel Joaquim", "200");
		
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
			t1 = TimeHelper.getMinutes("05/21/2013 06:00");
			t2 = TimeHelper.getMinutes("05/21/2013 06:30");
			t3 = TimeHelper.getMinutes("05/21/2013 07:00");
			t4 = TimeHelper.getMinutes("05/21/2013 07:30");
			t5 = TimeHelper.getMinutes("05/21/2013 08:00");
			t6 = TimeHelper.getMinutes("05/21/2013 08:30");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Flight flight1 = new Flight(1375, ap1, ap2, 200, t1, t2, 10, 100, 10, 100);
		Flight flight2 = new Flight(1376, ap2, ap3, 200, t1, t4, 10, 100, 10, 100);
		Flight flight3 = new Flight(1377, ap1, ap3, 200, t1, t4, 10, 100, 10, 100);
		Flight flight4 = new Flight(1378, ap3, ap1, 200, t1, t6, 10, 100, 10, 100);
		
		TailContainer<Flight> flights = new TailContainer<>();
		flights.addRecord(flight1);
		flights.addRecord(flight2);
		flights.addRecord(flight3);
		flights.addRecord(flight4);
		TailContainer<Plane> planes = new TailContainer<>();
		planes.addRecord(plane1);
		planes.addRecord(plane2);
		
		
		DepthFirst df = new DepthFirst(flights, planes);
		
		// The algorithm has a solution 
		assertFalse(df.run());
		
		// Check that the current flights assigned to all the planes
		// is equal to the total number of flights
		int numFlights = 0;
//		System.out.println(planes.getRecords().size());
		for (Plane plane : planes.getRecords()) {
			numFlights += plane.getSchedule().size();
//			System.out.println(numFlights);
		}
		// There should be no flights assigned has we 
		assertEquals(0, numFlights);
	}
	
	@Test
	public void testLoadFile() {
		TailContainer<Plane> planes = new TailContainer<Plane>();
		TailContainer<Flight> flights = new TailContainer<Flight>();
		TailContainer<Airport> airports = new TailContainer<Airport>();
		FileLoader.loadFiles(planes, airports, flights);
		
		DepthFirst df = new DepthFirst(flights, planes);
//		System.out.println("Flights size " + flights.size());
//		System.out.println("Planes size " + planes.size());
		
		// The algorithm has a solution 
		assertTrue("DF Falhou", df.run());
	}

}
