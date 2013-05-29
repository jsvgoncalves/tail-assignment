package test;

import static org.junit.Assert.*;

import logic.SimulatedAnnealing;

import org.junit.Test;

import util.TimeHelper;

import controller.Airport;
import controller.FileLoader;
import controller.Flight;
import controller.Plane;
import controller.TailContainer;

public class SwapTest {
	
	
	@Test
	public void swapTest(){
		System.out.println("::: Swap Test :::");
		TailContainer<Plane> state = new TailContainer<Plane>();
		Plane plane1 = new Plane("AAA", "Maria Joana", "200", 1.0, 1.0);
		Plane plane2 = new Plane("BBB", "Manuel Joaquim", "200", 1.0, 1.0);
		
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
		
		// *********************** (fNum Dept Arrv Type -Times- -----Seats-------)  
		Flight flight1 = new Flight(1375, ap1, ap2, 200, t1, t2, 10, 100, 10, 100);
		Flight flight2 = new Flight(1376, ap2, ap3, 200, t3, t4, 10, 100, 10, 100);
		Flight flight3 = new Flight(1377, ap1, ap3, 200, t1, t4, 10, 100, 10, 100);
		Flight flight4 = new Flight(1378, ap3, ap1, 200, t5, t6, 10, 100, 10, 100);
		Flight flight5 = new Flight(1379, ap3, ap1, 200, t5, t6, 10, 100, 10, 100);
		
		plane1.update(flight1);
		plane1.update(flight2);
		plane1.update(flight4);
		
		plane2.update(flight3);
		plane2.update(flight5);
		
		state.addRecord(plane1);
		state.addRecord(plane2);
		
		assertEquals(1378, state.get(0).getSchedule().get(2).number);
		
		/**
		 * Both planes leave AP1 at t1 and land on AP3 at t4.
		 * Both then leave AP# at the same time and could
		 * swap these flights.
		 */
		TailContainer<Plane> newState = new TailContainer<Plane>(state);
		assertTrue(SimulatedAnnealing.swap(newState, 1.0) >= 0.0);
		for (Plane plane : state.getRecords()) {
			System.out.println("Plane " + plane.getName());
			for (Flight flight : plane.getSchedule()) {
				System.out.println("\tFlight: " + flight.number);
			}
		}
		assertEquals("Maria Joana", newState.get(0).getName());
		assertEquals(1379, newState.get(0).getSchedule().get(2).number);
		
		System.out.println("\nAfter swap:");
		assertNotNull(newState);
		for (Plane plane : newState.getRecords()) {
			System.out.println("Plane " + plane.getName());
			for (Flight flight : plane.getSchedule()) {
				System.out.println("\tFlight: " + flight.number);
			}
		}
		
		// O voo #2 do Maria Joana era antes o 1378
		// Depois passa a ser o 1379
		assertEquals("Maria Joana", newState.get(0).getName());
		assertEquals(1379, newState.get(0).getSchedule().get(2).number);
		System.out.println("::: END SWAP :::");
	}

	@Test
	public void saTest(){
		System.out.println("::: Test Simualted Annealing :::");
		TailContainer<Plane> state = new TailContainer<Plane>();
		double fuelCost = 1.0;
		double maintCost = 1.0;
		Plane plane1 = new Plane("AAA", "Maria Joana", "200", fuelCost, maintCost);
		Plane plane2 = new Plane("BBB", "Manuel Joaquim", "200", fuelCost, maintCost);
		
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
		
		// *********************** (fNum Dept Arrv Type -Times- -----Seats-------)  
		Flight flight1 = new Flight(1375, ap1, ap2, 200, t1, t2, 10, 100, 10, 100);
		Flight flight2 = new Flight(1376, ap2, ap3, 200, t3, t4, 10, 100, 10, 100);
		Flight flight3 = new Flight(1377, ap1, ap3, 200, t1, t4, 10, 100, 10, 100);
		Flight flight4 = new Flight(1378, ap3, ap1, 200, t5, t6, 10, 100, 10, 100);
		Flight flight5 = new Flight(1379, ap3, ap1, 200, t5, t6, 10, 100, 10, 100);
		
		plane1.update(flight1);
		plane1.update(flight2);
		plane1.update(flight4);
		plane2.update(flight3);
		plane2.update(flight5);
		
		state.addRecord(plane1);
		state.addRecord(plane2);
		
		System.out.println("\nBefore Simulated Annealing:");
		for (Plane plane : state.getRecords()) {
			System.out.println("Plane " + plane.getName());
			for (Flight flight : plane.getSchedule()) {
				System.out.println("\tFlight: " + flight.number);
			}
		}
		
		SimulatedAnnealing sa = new SimulatedAnnealing();
		sa.run(state, 100, 0);
		System.out.println("\nAfter Simulated Annealing:");
		assertNotNull(state);
		
		for (Plane plane : state.getRecords()) {
			System.out.println("Plane " + plane.getName());
			for (Flight flight : plane.getSchedule()) {
				System.out.println("\tFlight: " + flight.number);
			}
		}
		System.out.println("::: END SA :::");
	}
	
	@Test
	public void saFileLoaderTest(){
		TailContainer<Plane> planes = new TailContainer<Plane>();
		TailContainer<Airport> airports = new TailContainer<Airport>();
		TailContainer<Flight> flights = new TailContainer<Flight>();
		FileLoader.loadFiles(planes, airports, flights);
		
		
		
		SimulatedAnnealing sa = new SimulatedAnnealing();
		int iMax = 100;
		double cMax = 0.0;
		sa.run(planes, iMax, cMax);
		
		System.out.println("::: SA File Loader :::");
		assertNotNull(planes);
		
		for (Plane plane : planes.getRecords()) {
			for (Flight flight : plane.getSchedule()) {
				System.out.println("\tFlight: " + flight.number);
			}
		}
		System.out.println("::: END SA File Loader :::");
	}
}


