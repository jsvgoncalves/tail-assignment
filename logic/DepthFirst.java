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
		System.out.println("Começou em " + new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds());
		boolean result =  boolDF(0);
		lastRunTime = new Date().getTime() - started;
		System.out.println("Total = " + lastRunTime);
		System.out.println("Acabou em " + new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds());
		return result;
	}
	
	public boolean boolDF(int flightID) {
		// Get available planes for this flight
		ArrayList<Plane> availablePlanes = getAvailablePlanes(flightID);
		if(availablePlanes.isEmpty()) {
			System.out.println("I've reached depth: " + flightID);
			System.out.println("I have this available: " + availablePlanes.size());
		}
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
//				System.err.println("getAvailablePlanes");
			}
		}
		
		return availPlanes;
//		return new ArrayList<Plane>();
	}

	/**
	 * Starts the DepthFirst algorithm
	 * @param planes
	 * @return
	 */
	public TailContainer<Plane> dfRecursive(TailContainer<Plane> planes){
		int flightID = 0;
		return dfRecursive(flightID, planes);
	}
	
	/**
	 * The DepthFirst algorithm
	 * @param flightID
	 * @param planes
	 * @return
	 */
	private TailContainer<Plane> dfRecursive(int flightID, TailContainer<Plane> planes){
		
		System.out.println("im at " + planes.get(flightID).getName());
		// These planes can perform the flight with "flightID":availablePlanes
		ArrayList<Plane> availablePlanes = getAvailablePlanes(flightID, planes);

		// Break the assignment if no further assignment is possible (track back):
		if(availablePlanes.isEmpty()){
			return new TailContainer<Plane>();
		}

		// Create new search "branches". Stop if any branch found a solution:
		for (Plane plane : availablePlanes) {
			plane.update((Flight) flights.get(flightID));
			if(flightID == flights.size() - 1){
				// If this is the last tree level (last flight), then solution WAS FOUND
				TailContainer<Plane> schedule = new TailContainer<Plane>();
				schedule.addRecord(plane);
				return schedule;
			}
			
			// Still not the last plane. We need to go deeper:
			TailContainer<Plane> schedule = dfRecursive(flightID + 1, planes);
			if(!schedule.isEmpty()){
				// Partial solution found.
				// Now add this flight to partial solution
				((Plane) schedule.getLast()).update(flights.get(flightID));
				return schedule;
			}
		}

		// Reaching here means no solution was found in search branches.
		return new TailContainer<Plane>();
	}

	/**
	 * Gets the available plane for a given flight
	 * @param flightID The index of the flight in the flights TailContainer
	 * @param planes
	 * @return
	 */
	private ArrayList<Plane> getAvailablePlanes(int flightID, TailContainer<Plane> planes){
		ArrayList<Plane> availPlanes = new ArrayList<Plane>();
		
		for (Plane plane : planes.getRecords()) {
			if(plane.canPerform(flights.get(flightID))){
				availPlanes.add(plane);
				System.err.println("getAvailablePlanes");
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
