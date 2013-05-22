package logic;

import java.util.ArrayList;

import controller.Airport;
import controller.Flight;
import controller.Plane;
import controller.TailContainer;
import logic.DepthFirst;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TailContainer<Plane> planes = new TailContainer<Plane>();
		TailContainer<Flight> flights = new TailContainer<Flight>();
		TailContainer<Airport> airports = new TailContainer<Airport>();
		ArrayList<String> params = new ArrayList<String>();
		
		DepthFirst df = new DepthFirst(flights);
		TailContainer<Plane> firstSol = df.dfRecursive(planes);
		
		int maxIterations = 5;
		double maxCost = 1.0;
		
		SimulatedAnnealing sa = new SimulatedAnnealing(flights, planes, airports, params);
		sa.run(firstSol, maxIterations, maxCost);
	}

}
