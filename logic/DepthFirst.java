package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import controller.*;

/**
 * 
 * @author joao
 *
 */
public class DepthFirst {
	
	private TailContainer<Flight> flights;
	private TailContainer<Plane> planes;
	// Auxiliar to the algorithm (redundant but processor saver)
	private int flightSize = 0;
	static long lastRunTime = 0;
	
	/**
	 * Constructor
	 * @param flights
	 */
	public DepthFirst(TailContainer<Flight> flights, TailContainer<Plane> planes) {
		this.flights = flights;
		this.flightSize = flights.size() - 1;
		this.planes = planes;
	}
	
	public boolean run() {
		long started = new Date().getTime();
		boolean result =  depthFirst(0);
		lastRunTime = new Date().getTime() - started;
		return result;
	}
	
	public boolean depthFirst(int flightID) {
		// Get available planes for this flight
		ArrayList<Plane> availablePlanes = getAvailablePlanes(flightID);
		
		
		
		// If all flights have been given planes we have a solution
		if(flightID == this.flightSize && !availablePlanes.isEmpty()) {
			availablePlanes.get(0).update(flights.get(flightID));
			return true;
		} 

		for (Plane plane : availablePlanes) {
			plane.update(flights.get(flightID));
			boolean success = depthFirst(flightID + 1);
			if(success) {
				return true;
			} else {
				plane.removeFlight(flights.get(flightID));
			}
		}
		return false;
	}
	
	private ArrayList<Plane> getAvailablePlanes(int flightID) {
		ArrayList<Plane> availPlanes = new ArrayList<Plane>();
		Flight curFlight = this.flights.get(flightID);
		
		for (Plane plane : planes.getRecords()) {
			if(plane.canPerform(curFlight)){
				availPlanes.add(plane);
			}
		}
		return sortPlanes(availPlanes, flights.get(flightID));
	}
	
	/**
	 * Implements quicksort to sort the available Planes
	 * @param planes
	 * @param flight
	 * @return
	 */
	private ArrayList<Plane> sortPlanes(ArrayList<Plane> planes, Flight flight) {
//		function quicksort('array')
//	      if length('array') ≤ 1
//	          return 'array'  // an array of zero or one elements is already sorted
//	      select and remove a pivot value 'pivot' from 'array'
//	      create empty lists 'less' and 'greater'
//	      for each 'x' in 'array'
//	          if 'x' ≤ 'pivot' then append 'x' to 'less'
//	          else append 'x' to 'greater'
//	      return concatenate(quicksort('less'), 'pivot', quicksort('greater')) // two recursive calls
		
//		ArrayList<Plane> sorted = new ArrayList<Plane>();
		if(planes.size() <= 1) {
			return planes;
		}
		
		// Select a pivot and remove it
		int index = planes.size() / 2;
		Plane pivot = planes.remove(index);
		
		ArrayList<Plane> less = new ArrayList<Plane>();
		ArrayList<Plane> greater = new ArrayList<Plane>();
		for (Plane plane : planes) {
			// if lesser append to less
//			System.out.println(plane.getFuelCost() + " ? " + pivot.getFuelCost());
			if(plane.getFuelCost() < pivot.getFuelCost()) {
				less.add(plane);
			} else {
				greater.add(plane);
			}
		}
		ArrayList<Plane> rLess = sortPlanes(less, flight);
		ArrayList<Plane> rGreater = sortPlanes(less, flight);
		rLess.add(pivot);
		rLess.addAll(rGreater);
		return rLess;
	}
}
