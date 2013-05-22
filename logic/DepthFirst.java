package logic;

import java.util.ArrayList;

import controller.*;

/**
 * 
 * @author joao
 *
 */
public class DepthFirst {
	
	private TailContainer<Flight> fligths;
	
	public DepthFirst(TailContainer<Flight> fligths) {
		this.fligths = fligths;
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
			plane.update((Flight) fligths.get(flightID));
			TailContainer<Plane> schedule = dfRecursive(flightID + 1, planes);
			if(!schedule.isEmpty()){
				// Partial solution found.
				// Now add this flight to partial solution
				schedule.get(schedule.lastIndexOf(plane)).update(fligths.get(flightID));
				return schedule;
			}
		}

		// Reaching here means solution was found in no search branches.
		return new TailContainer<Plane>();
	}

	private ArrayList<Plane> getAvailablePlanes(int flightID, TailContainer<Plane> planes){
		ArrayList<Plane> availPlanes = new ArrayList<Plane>();
		
		for (Plane plane : planes) {
			if(plane.canPerform(fligths.get(flightID))){
				
			}
		}
		
		return availPlanes;
	}
}
