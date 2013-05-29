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
		boolean result =  boolDF(0);
		lastRunTime = new Date().getTime() - started;
		return result;
	}
	
	public boolean boolDF(int flightID) {
		// Get available planes for this flight
		ArrayList<Plane> availablePlanes = getAvailablePlanes(flightID);
		
		// If all flights have been given planes we have a solution
		if(flightID == this.flightSize && !availablePlanes.isEmpty()) {
			availablePlanes.get(0).update(flights.get(flightID));
			return true;
		} 

		for (Plane plane : availablePlanes) {
			plane.update(flights.get(flightID));
			boolean success = boolDF(flightID + 1);
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
		
		for (Plane plane : planes.getRecords()) {
			Flight curFlight = this.flights.get(flightID);
			if(plane.canPerform(curFlight)){
				availPlanes.add(plane);
			}
		}
		
		return availPlanes;
	}
	
	public boolean getFirstSol(){
		LinkedList<Flight> fs = new LinkedList<Flight>(flights.getRecords()); 
		for (Plane plane : planes.getRecords()) {
			for (Iterator<Flight> iterator = fs.iterator(); iterator.hasNext();) {
				Flight flight = (Flight) iterator.next();
				if (plane.canPerform(flight)) {
					plane.update(flight);
					iterator.remove();
				}
			}
		}
		System.err.println("Flights left: " + fs.size());
		return fs.isEmpty();
	}
}
