package logic;

import java.util.ArrayList;

import controller.*;

/**
 * 
 * @author joao
 *
 */
public class DepthFirst {
	
	private TailContainer<Flight> flights;
	
	public DepthFirst(TailContainer<Flight> flights) {
		this.flights = flights;
	}
	
	public TailContainer<Plane> dfRecursive(TailContainer<Plane> planes){
		int flightID = 0;
		return dfRecursive(flightID, planes);
	}
	
	private TailContainer<Plane> dfRecursive(int flightID, TailContainer<Plane> planes){
		
		// These planes can perform the flight with "flightID":
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
}
