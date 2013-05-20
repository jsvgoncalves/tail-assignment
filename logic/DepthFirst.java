package logic;

import java.util.ArrayList;

import controller.*;

/**
 * 
 * @author joao
 *
 */
public class DepthFirst {

	private class Pair{
		public Plane plane;
		public int flightID;
		public Pair(Plane p, int f){
			plane = p;
			flightID = f;
		}
	}
	
	public void dfRecursive(ArrayList<Integer> flights, ArrayList<Plane> planes){
		int flightID = 0;
		dfRecursive(0, planes);
	}
	
	private ArrayList<Pair> dfRecursive(int flightID, ArrayList<Plane> planes){
		
		// These planes can perform the flight with "flightID":
		ArrayList<Plane> availablePlanes = getAvailablePlanes(flightID, planes);

		// Break the assignment if no further assignment is possible (track back):
		if(availablePlanes.isEmpty()){
			return new ArrayList<Pair>();
		}

		// Create new search "branches". Stop if any branch found a solution:
		for (Plane plane : availablePlanes) {
			plane.update(flightID);
			ArrayList<Pair> pairs = dfRecursive(flightID + 1, planes);
			if(!pairs.isEmpty()){ // Solution found
				pairs.add(new Pair(plane, flightID));
				return pairs;
			}
		}

		// Reaching here means solution was found in no search branches.
		return new ArrayList<Pair>();
	}

	private ArrayList<Plane> getAvailablePlanes(int flightID, ArrayList<Plane> planes){
		ArrayList<Plane> availPlanes = new ArrayList<Plane>();
		
		
		
		return availPlanes;
	}
}
