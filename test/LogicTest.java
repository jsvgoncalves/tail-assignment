package test;

import static org.junit.Assert.*;

import logic.DepthFirst;
import logic.SimulatedAnnealing;

import org.junit.Test;

import util.TimeHelper;

import controller.Airport;
import controller.Flight;
import controller.Plane;
import controller.TailContainer;

public class LogicTest {
	
	@Test
	public void swapTest(){
		TailContainer<Plane> state = new TailContainer<Plane>();
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
		
		plane1.update(flight1);
		plane1.update(flight3);
		plane1.update(flight4);
		plane2.update(flight2);
		
		state.addRecord(plane1);
		state.addRecord(plane2);
		
		/**
		 * Plane 1: 1375 -> 1376 -> 1378
		 * Plane 2: 1377
		 * 
		 * Alternative course:
		 * Plane 1: 1376 -> 1376
		 * Plane 2: 1377 -> 1378
		 */
		TailContainer<Plane> newState = SimulatedAnnealing.swap(state);
		for (Plane plane : state.getRecords()) {
			System.out.println("Plane " + plane.getName());
			for (Flight flight : plane.getSchedule()) {
				System.out.println("\tFlight: " + flight.number);
			}
		}
		
		System.out.println("\nAfter swap:");
		for (Plane plane : newState.getRecords()) {
			System.out.println("Plane " + plane.getName());
			for (Flight flight : plane.getSchedule()) {
				System.out.println("\tFlight: " + flight.number);
			}
		}
		
		assertTrue(newState != state);
	}
}


