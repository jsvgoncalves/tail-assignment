package logic;

import java.util.ArrayList;
import java.util.Random;

import controller.Airport;
import controller.Flight;
import controller.Plane;
import controller.TailContainer;

public class SimulatedAnnealing {

	// private static ArrayList<String> representation;
	private TailContainer<Flight> fligths;
	private TailContainer<Plane> planes;
	private TailContainer<Airport> airports;
	private ArrayList<String> params;
	
	public SimulatedAnnealing(
			TailContainer<Flight> flights,
			TailContainer<Plane> planes,
			TailContainer<Airport> airports,
			ArrayList<String> params) {
		this.fligths = flights;
		this.planes = planes;
		this.airports = airports;
	}
	
	public void run(TailContainer<Plane> firstSol, int iMax, double cMax) {
		TailContainer<Plane> sol = firstSol; // current solution
		double cost = cost(sol); //cost of the current solution
		
		int i = 0;
		
		// Will stop after i_max iterations
		//  or after a solution with acceptable cost
		//	was found
		while (i < iMax && cost > cMax){
			// Swap some two planes' flights schedule to
			//  generate a new schedule:
			TailContainer<Plane> newSol = swap(sol);
			double newCost = cost(newSol);
			
			// The temperature value depends on the
			//  progression of the algorithm.
			double t = temperature(i, iMax);
			Random r = new Random();
			
			// Probability of accepting new_sol. p is directly
			//  proportional to the value of t and inversely proportional
			//  to the value of the ratio cost/new_cost, thus:
			//  new_cost < cost => p > 100%
			double p = probability(t, cost, newCost);
			
			if (p > r.nextDouble()){
				// accept solution
				sol = newSol;
				cost = newCost;
			}
			i++;
		}
	}

	private double probability(double t, double cost, double newCost) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Generates a new state from the previous one by searching
	 * for a possible swap of operation between two planes.
	 * @param sol
	 * @return
	 */
	private TailContainer<Plane> swap(TailContainer<Plane> state) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * The value of temperature return is inversely
	 * proportional to the current progression of the 
	 * algorithm, given by i.
	 * @param i
	 * @param iMax
	 * @return
	 */
	private double temperature(int i, int iMax) {
		return iMax/i;
	}

	private double cost(TailContainer<Plane> sol) {
		double cost = 0;
		
		for (int i = 0; i < sol.size(); i++) {
			sol.get(i).getCost();
		}
		
		return cost;
	}
}
